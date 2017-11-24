package com.meixiang.beauty.webapp.business.task;

import com.meixiang.beauty.modules.account.HealthDataService;
import com.meixiang.beauty.modules.transaction.api.SurveyService;
import com.meixiang.beauty.modules.training.api.WechatCoreService;
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
