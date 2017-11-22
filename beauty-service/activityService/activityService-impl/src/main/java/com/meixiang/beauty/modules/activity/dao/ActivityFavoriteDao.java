/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.activity.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.activity.entity.ActivityFavorite;
import org.springframework.stereotype.Repository;


@MyBatisDao
@Repository
public interface ActivityFavoriteDao {

	Integer addActivityFavorite(ActivityFavorite activityFavorite);

	Integer delActivityFavorite(ActivityFavorite activityFavorite);

}
