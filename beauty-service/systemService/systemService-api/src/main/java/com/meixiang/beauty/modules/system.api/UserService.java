package com.meixiang.beauty.modules.system.api;


import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.sys.entity.WechatBean;

/**
 * Created by zbm84 on 2017/5/27.
 */
public interface UserService {

    String login(String phone, String code, String loginIP, WechatBean wechatBean) throws Exception;

    String loginOut(String loginToken);

    UserInfoDTO getUserInfo(String userId);
}
