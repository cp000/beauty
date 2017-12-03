/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.LoginDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wechat.WeixinTokenDTO;
import com.meixiang.beauty.common.utils.WechatUtil;
import com.meixiang.beauty.common.web.BaseController;
import com.meixiang.beauty.modules.system.api.SystemService;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import com.meixiang.beauty.sys.entity.WechatBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 登录 Controller
 *
 * @author 张博
 * @version 2017-5-5
 */
@Controller
@RequestMapping(value = "system")
public class LoginController extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private SystemService systemService;


    /**
     * 用户通过微信中的H5，实现手机号绑定登录
     */
    @RequestMapping(value = "login", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<String> login(@RequestBody LoginDTO loginDTO,
                                HttpServletRequest request,
                                HttpSession session) throws Exception {

        //获取用户的基本信息
        String openid = WechatUtil.getOpenId(session,request);
        WeixinTokenDTO weixinTokenDTO = systemService.getWeixinParameter();
        WechatBean wechatBean = WechatUtil.getWechatName(weixinTokenDTO.getToken(),openid);

        String loginResult = userService.login(loginDTO.getUserPhone(), loginDTO.getCode(), request.getRemoteAddr().toString(),wechatBean);
        ResponseDTO<String> result = new ResponseDTO<>();

        if (loginResult.equals(StatusConstant.VALIDATECODE_ERROR))
        {
            result.setResult(StatusConstant.FAILURE);
            result.setErrorInfo("验证码输入不正确");
            return result;
        }
        else
        {
            result.setResult(StatusConstant.SUCCESS);
            result.setErrorInfo("调用成功");
            result.setResponseData(loginResult);
            return result;
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "loginout", method = {RequestMethod.POST, RequestMethod.GET})
    @LoginRequired
    public
    @ResponseBody
    ResponseDTO<UserInfoDTO> loginout(HttpServletRequest request) {
        String loginToken = request.getHeader("logintoken");
        if(loginToken==null||loginToken.equals("")){
            loginToken=request.getSession().getAttribute("token").toString();
        }
        String status = userService.loginOut(loginToken);
        ResponseDTO<UserInfoDTO> result = new ResponseDTO<UserInfoDTO>();
        result.setResult(status);
        result.setErrorInfo(status.equals(StatusConstant.LOGIN_OUT) ? "退出登录" : "保持在线");
        return result;
    }

    /**
     * 发送验证码
     */
    @RequestMapping(value = "sendIdentifying", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO sendIdentifying(@RequestBody UserInfoDTO userInfoDto) {
        ResponseDTO result = new ResponseDTO<>();
        result.setResult(userService.sendMessage(userInfoDto.getMobile()));
        return result;
    }
}
