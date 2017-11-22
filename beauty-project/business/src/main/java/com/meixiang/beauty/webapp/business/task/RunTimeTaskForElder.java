package com.meixiang.beauty.webapp.business.task;

import com.meixiang.beauty.modules.healthData.service.HealthDataService;
import com.meixiang.beauty.modules.my.service.SurveyService;
import com.meixiang.beauty.modules.weChat.service.WechatCoreService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by sunxiao on 2017/9/14.
 */
public class RunTimeTaskForElder {

    @Autowired
    WechatCoreService wechatCoreService;

    @Autowired
    SurveyService surveyService;

    @Autowired
    HealthDataService healthDataService;

    public void updateWechatInfo(){
        wechatCoreService.updateWechatInfo();
    }

    public void arrangementSurveyInfo(){
        surveyService.arrangementSurveyInfo();
    }

    public void makeHealthData(){
        healthDataService.makeHealthData();
    }
}
