package com.meixiang.beauty.modules.activity.dao;


import com.meixiang.beauty.common.dto.activity.ActivityDiscussDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.activity.entity.ActivityDiscuss;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zbm84 on 2017/7/27.
 */
@MyBatisDao
@Repository
public interface ActivityDiscussDao {

    Integer addActivityDiscuss(ActivityDiscuss activityDiscuss);

    List<ActivityDiscussDTO> getActivityDiscussList(@Param("id")String id, @Param("page") Integer page);

}
