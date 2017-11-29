package com.meixiang.beauty.modules.weixin.impl;

import com.meixiang.beauty.modules.wechat.api.WechatAttentionService;
import com.meixiang.beauty.modules.weixin.dao.WechatAttentionDao;
import com.meixiang.beauty.modules.wechat.entity.DoctorAttentionVo;
import com.meixiang.beauty.modules.wechat.entity.SysWechatAppintInfoVo;
import com.meixiang.beauty.modules.wechat.entity.WechatAttention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author wangbaowei
 * @date 2015-11-04
 */

@Service
@Transactional(readOnly = false)
public class WechatAttentionServiceImpl implements WechatAttentionService {

   @Autowired
	private WechatAttentionDao wechatattentionDao;
	 
    //根据openId查询关注信息
    @Override
    public SysWechatAppintInfoVo findAttentionInfoByOpenId(SysWechatAppintInfoVo sysWechatAppintInfoVo) {
         List<SysWechatAppintInfoVo> resultVo = wechatattentionDao.findAttentionInfoByOpenId(sysWechatAppintInfoVo);
         SysWechatAppintInfoVo wechatAppintInfoVo = new SysWechatAppintInfoVo();
         if(resultVo!=null && resultVo.size()>0){
             wechatAppintInfoVo = resultVo.get(0);
         }
        return wechatAppintInfoVo;
    }

    @Override
    public SysWechatAppintInfoVo getAttentionInfoByOpenId(SysWechatAppintInfoVo sysWechatAppintInfoVo) {
        List<SysWechatAppintInfoVo> resultVo = wechatattentionDao.findAttentionInfoByOpenId(sysWechatAppintInfoVo);
        SysWechatAppintInfoVo wechatAppintInfoVo = new SysWechatAppintInfoVo();
        if(resultVo!=null && resultVo.size()>0){
            wechatAppintInfoVo = resultVo.get(0);
        }
        return wechatAppintInfoVo;
    }

    @Override
    public List<SysWechatAppintInfoVo> findAttentionInfo(SysWechatAppintInfoVo sysWechatAppintInfoVo) {
        List<SysWechatAppintInfoVo> resultVo = wechatattentionDao.findAttentionInfoByOpenId(sysWechatAppintInfoVo);
        return resultVo;
    }

    @Override
    public HashMap<String,Object> getAttention(String open_id){
    	return wechatattentionDao.getAttention(open_id);
    }

    @Override
    public WechatAttention getAttentionByOpenId(String open_id){
        return wechatattentionDao.getAttentionByOpenId(open_id);
    }
    
    //根据openId查询关注信息列表
    @Override
	public List<SysWechatAppintInfoVo> findAttentionInfoByOpenIdLists(SysWechatAppintInfoVo sysWechatAppintInfoVo){
    	return wechatattentionDao.findAttentionInfoByOpenIdLists(sysWechatAppintInfoVo);
    }

    @Override
    public DoctorAttentionVo findDoctorAttentionVoInfoNoOpenId(HashMap<String,Object> hashMap){
    	return wechatattentionDao.findDoctorAttentionVoInfoNoOpenId(hashMap);
    }

}
