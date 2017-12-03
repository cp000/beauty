package com.meixiang.beauty.web.system.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.modules.system.api.UserService;
import com.meixiang.beauty.sys.annotation.LoginRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;

/**
 * 关于账户管理
 * @author 张博
 * @date 2017-5-5
 */
@Controller
@RequestMapping(value = "system")
public class SelfCenterController {

    @Autowired
    private UserService userService;



}
