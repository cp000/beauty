package com.meixiang.beauty.modules.weChat.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;

import java.util.HashMap;

/**
 * Created by sunxiao on 2017/9/11.
 */
@MyBatisDao
public interface WechatInfoDao {

    void updateWechatParameter(HashMap<String, Object> Map);

    HashMap<String,Object> getWechatParameter();

}
