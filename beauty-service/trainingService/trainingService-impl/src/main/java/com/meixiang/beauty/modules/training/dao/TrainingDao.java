package com.meixiang.beauty.modules.training.dao;


import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.training.entity.WechatUserBind;


import java.util.List;

/**
 * Created by sunxiao on 2017/9/12.
 */
@MyBatisDao
public interface TrainingDao {

    void insertWechatUserBind(WechatUserBind wechatUserBind);

    List<WechatUserBind> findWechatUserBindByInfo(WechatUserBind wechatUserBind);
}
