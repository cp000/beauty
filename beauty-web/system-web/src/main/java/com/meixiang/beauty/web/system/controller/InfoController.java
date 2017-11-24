package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.ResponseDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.UserInfoDTO;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.User;
import com.meixiang.beauty.sys.service.EasemobService;
import com.meixiang.beauty.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 关于账户管理
 * @author 张博
 * @date 2017-5-5
 */
@Controller
@RequestMapping(value = "")
public class InfoController {

    private static Lock lock = new ReentrantLock();

    private static ExecutorService threadExecutor = Executors.newSingleThreadExecutor();

    @Autowired
    private UserService userService;

    @Autowired
    private EasemobService easemobService;

    /**
     * 修改用户头像;
     *
     *
     */
    @RequestMapping(value = "laoyou/updateHeadImage", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateHeadImage(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setPhoto(userInfoDto.getHeadImage());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }

    /**
     * 修改用户姓名
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserName", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserName(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request)throws Exception {
        User user=UserService.getUser(request);
        user.setId(user.getId());
        user.setName(userInfoDto.getName());
        if(userInfoDto.getAge()!=null&&!userInfoDto.getAge().equals("")){
            user.setAge(userInfoDto.getAge());
        }
        if(userInfoDto.getGender()!=null&&!userInfoDto.getGender().equals("")){
            user.setGender(userInfoDto.getGender());
        }
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            //if(easemobService.updateEasemobUserNickName(user.getSysPractitionerUser().getEasemobID(),userInfoDto.getName())){
                responseDto.setResult(StatusConstant.SUCCESS);
                responseDto.setErrorInfo("");
                return responseDto;
            //}else{
            //   responseDto.setResult(StatusConstant.FAILURE);
            //    responseDto.setErrorInfo("");
            //    return responseDto;
            //}
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 修改用户性别
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserGender", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserGender(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setGender(userInfoDto.getGender());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 修改用户地区
     *
     *
     */
    @RequestMapping(value = "laoyou/updateUserArea", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> updateUserArea(@RequestBody UserInfoDTO userInfoDto, HttpServletRequest request) {
        User user=UserService.getUser(request);
        user.setArea(userInfoDto.getArea());
        ResponseDTO<UserInfoDTO> responseDto=new ResponseDTO<>();
        if (userService.updateUser(user)){
            userService.updateRedisUser(request);
            responseDto.setResult(StatusConstant.SUCCESS);
            responseDto.setErrorInfo("");
            return responseDto;
        }else {
            responseDto.setResult(StatusConstant.FAILURE);
            responseDto.setErrorInfo("");
            return responseDto;
        }
    }


    /**
     * 获取用户信息
     *
     *
     */
    @RequestMapping(value = "laoyou/getUserInfo", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> getUserInfo(HttpServletRequest request) {
        ResponseDTO responseDto = new ResponseDTO();
        User user = UserService.getUser(request);
        responseDto.setResponseData(user);
        responseDto.setResult(StatusConstant.SUCCESS);
        return responseDto;
    }

}
