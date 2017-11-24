package com.meixiang.beauty.webapp.business.task;


import com.meixiang.beauty.modules.wechat.api.WechatCoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunxiao on 2017/9/14.
 */
public class RunTimeTaskForBusiness {

    @Autowired
    WechatCoreService wechatCoreService;

    public void updateWechatInfo(){
        wechatCoreService.updateWechatInfo();
    }


}
