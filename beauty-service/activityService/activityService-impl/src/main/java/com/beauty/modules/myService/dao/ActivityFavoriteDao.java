/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.beauty.modules.myService.dao;

import com.yhl.laoyou.common.persistence.annotation.MyBatisDao;
import com.beauty.modules.activityService.entity.ActivityFavorite;
import org.springframework.stereotype.Repository;


@MyBatisDao
@Repository
public interface ActivityFavoriteDao {

	Integer addActivityFavorite(ActivityFavorite activityFavorite);

	Integer delActivityFavorite(ActivityFavorite activityFavorite);

}
