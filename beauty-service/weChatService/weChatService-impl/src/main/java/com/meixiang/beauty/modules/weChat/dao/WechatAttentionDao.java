package com.meixiang.beauty.modules.weChat.dao;


import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.weChat.entity.WechatAttention;

import java.util.HashMap;
import java.util.Map;

@MyBatisDao
public interface WechatAttentionDao {

    void insertAttentionInfo(HashMap<String,Object> codeMap);

    WechatAttention getAttentionByOpenId(String open_id);

    //根据openid查询最近关注的marketer，防止取消关注的时候marketer总是为空
    WechatAttention findMarketerByOpeinid(WechatAttention wechatAttention);

    void updateAttentionInfo(Map map);

}