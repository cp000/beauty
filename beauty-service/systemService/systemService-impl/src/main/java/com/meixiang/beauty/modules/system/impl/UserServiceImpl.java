package com.meixiang.beauty.modules.system.impl;

import com.aliyun.opensearch.sdk.dependencies.com.google.gson.Gson;
import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.system.ValidateCodeDTO;
import com.meixiang.beauty.common.utils.*;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.sys.dao.UserDao;
import com.meixiang.beauty.sys.entity.WechatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

    private Gson gson = new Gson();

    @Autowired
    private UserDao userDao;

    @Autowired
    protected MongoTemplate mongoTemplate;

    @Override
    public String login(String phone, String code, String loginIP, WechatBean wechatBean) throws Exception {

        //判断validateCode是否还有效
        Query query = new Query().addCriteria(Criteria.where("mobile").is(phone))
                .addCriteria(Criteria.where("code").is(code));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createDate")));
        List<ValidateCodeDTO> data = mongoTemplate.find(query, ValidateCodeDTO.class,"validateCode");
        if(data==null)
        {
            return StatusConstant.VALIDATECODE_ERROR;
        }
        else
        {
            ValidateCodeDTO validateCodeDTO = data.get(0);

            String dateStr = validateCodeDTO.getCreateDate();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = dateFormat.parse(dateStr);

            long period =  (new Date()).getTime() - date.getTime();

            //验证码过了5分钟了
            if(period>300000)
            {
                return  StatusConstant.VALIDATECODE_ERROR;
            }
        }

        //validateCode有效后，判断sys_user表中，是否存在此用户，如果存在，则成功返回登录，如果不存在，则创建用户后，返回登录成功
        UserInfoDTO userInfoDTO = new UserInfoDTO();
        userInfoDTO.setMobile(phone);
        List<UserInfoDTO> userInfoDTOList = userDao.getUserByInfo(userInfoDTO);
        RedisLock redisLock = new RedisLock("userLogin");
        try {
            redisLock.tryLock(1, TimeUnit.SECONDS);

            userInfoDTO.setLoginDate(new Date());
            userInfoDTO.setLoginIp(loginIP);
            userInfoDTO.setUserOpenid(wechatBean.getOpenid());
            userInfoDTO.setNickname(wechatBean.getNickname());

            if(userInfoDTOList.size()>0)
            {
                //用户已经存在，更新用户登录信息
                userInfoDTO.setId(userInfoDTOList.get(0).getId());
                userDao.updateUserInfo(userInfoDTO);
            }
            else
            {
                //用户不存在，创建新用户
                userInfoDTO.setId(UUID.randomUUID().toString());
                userDao.insertUserInfo(userInfoDTO);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            return StatusConstant.VALIDATECODE_ERROR;
        }
        redisLock.unlock();

        //登录成功后，将用户信息放置到redis中，生成loginToken供前端使用
        String loginToken = UUID.randomUUID().toString();
        String userInfoStr = gson.toJson(userInfoDTO);
        JedisUtils.set(loginToken,userInfoStr,24*60*60*30);

        return loginToken;
    }

    @Override
    public String loginOut(String loginToken) {
        JedisUtils.del(loginToken);
        return StatusConstant.LOGIN_OUT;
    }

    @Override
    public UserInfoDTO getUserInfo(String userId) {
        return null;
    }

    @Override
    public List<UserInfoDTO> getAllUserInfo(PageParamDTO<String> pageParamDTO) {
        return null;
    }


}
