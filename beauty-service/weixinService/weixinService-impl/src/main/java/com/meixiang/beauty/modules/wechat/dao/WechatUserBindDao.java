package com.meixiang.beauty.modules.wechat.dao;


import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.wechat.entity.WechatUserBind;
import java.util.List;

/**
 * Created by sunxiao on 2017/9/12.
 */
@MyBatisDao
public interface WechatUserBindDao {

    void insertWechatUserBind(WechatUserBind wechatUserBind);

    List<WechatUserBind> findWechatUserBindByInfo(WechatUserBind wechatUserBind);
}
