package com.meixiang.beauty.modules.system.api;


import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wechat.WeixinTokenDTO;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface SystemService {

    //获取微信的token
    WeixinTokenDTO getWeixinParameter();

    String sendMessage(String phoneNum);

    UserInfoDTO addSuggestion(String userId, String suggestion);

}
