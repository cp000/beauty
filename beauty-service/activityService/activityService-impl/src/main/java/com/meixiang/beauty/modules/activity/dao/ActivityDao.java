/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.activity.dao;

import com.meixiang.beauty.common.dto.activity.ActivityDTO;
import com.meixiang.beauty.common.dto.activity.AttendedActivityDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.activity.entity.Activity;
import com.meixiang.beauty.modules.activity.entity.ActivityFavorite;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@MyBatisDao
@Repository
public interface ActivityDao {

	Integer addActivity(Activity activityDTO);

	List<ActivityDTO> getActivityList(@Param("id") String activityId, @Param("search") String search);

	List<AttendedActivityDTO> getActivityListByElderID(@Param("elderID") String elderID);

	List<ActivityDTO> getMyActivityListByElderID(@Param("elderID") String elderID, @Param("pageNo") Integer pageNo, @Param("activityType") String activityType);

	Integer updateActivityStatus(@Param("status") String Status, @Param("id") String id);

	List<Activity> getActivityListByTask();

	List<ActivityFavorite> getActivityFavoriteListByElderID(@Param("sysElderUserID") String sysElderUserID);

	List<ActivityDTO> getMyFavoriteActivityList(@Param("sysElderUserID") String sysElderUserID);

	List<ActivityDTO> getMyHospitalActivityListByHospitalID(@Param("hospitalID") String hospitalID);

	Activity getActivityByGroupID(String groupID);

	List<Activity> getReadyActivity();

	Integer updateActivityEasemobGroup(@Param("id") String id, @Param("easemobGroupID") String easemobGroupID);

	Integer insertIP(@Param("IP")String IP);

	Page<ActivityDTO> getActivityListByBackEnd(@Param("hospitalID") String hospitalID,
											   @Param("status") String status,
											   @Param("searchValue") String searchValue,
											   @Param("startDate") String startDate,
											   @Param("endDate") String endDate,
											   Page page);

}
