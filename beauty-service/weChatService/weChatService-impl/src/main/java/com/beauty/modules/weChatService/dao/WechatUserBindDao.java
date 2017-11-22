package com.beauty.modules.weChatService.dao;

import com.yhl.laoyou.common.persistence.annotation.MyBatisDao;
import com.beauty.modules.weChatService.entity.WechatUserBind;

import java.util.List;

/**
 * Created by sunxiao on 2017/9/12.
 */
@MyBatisDao
public interface WechatUserBindDao {

    void insertWechatUserBind(WechatUserBind wechatUserBind);

    List<WechatUserBind> findWechatUserBindByInfo(WechatUserBind wechatUserBind);
}
