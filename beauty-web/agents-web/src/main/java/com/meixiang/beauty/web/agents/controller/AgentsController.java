package com.meixiang.beauty.web.agents.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.PageParamDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.modules.system.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "agents")
public class AgentsController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有的系统中的用户
     *
     * input PageParamDTO<String>
     * String为normal代表所有用户（不含管理员），
     * 为A代表为A级代理用户，B为B级代理用户，business为普通用户，
     * M为系统中所有管理员用户
     *
     *
     */
    @RequestMapping(value = "userList", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<List<UserInfoDTO>> userList(@RequestBody PageParamDTO<String> pageParamDTO) {
        ResponseDTO<List<UserInfoDTO>> result = new ResponseDTO<>();
        List<UserInfoDTO> userInfoDTOList = userService.getAllUserInfo(pageParamDTO);
        result.setResponseData(userInfoDTOList);
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }


}
