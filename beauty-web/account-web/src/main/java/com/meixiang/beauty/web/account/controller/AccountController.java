package com.meixiang.beauty.web.account.controller;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.common.dto.system.ResponseDTO;
import com.meixiang.beauty.modules.account.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 微信页面参数获取相关的控制类
 * Created by baoweiw on 2015/7/27.
 */

@Controller
@RequestMapping(value = "account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 获取用户的账户信息
     */
    @RequestMapping(value = "userAccountInfo", method = {RequestMethod.POST, RequestMethod.GET})
    public
    @ResponseBody
    ResponseDTO<AccountDTO> sendIdentifying(@RequestParam String userId) {
        ResponseDTO<AccountDTO> result = new ResponseDTO<>();
        AccountDTO accountInfo = accountService.getUserAccountInfo(userId);
        result.setResponseData(accountInfo);
        result.setResult(StatusConstant.SUCCESS);
        return result;
    }

}
