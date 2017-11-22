/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.sys.entity.Office;
import org.apache.ibatis.annotations.Param;


@MyBatisDao
public interface OfficeDao {

    int insertOffice(Office sysHospitalUserDTO);

    Office getOfficeByID(String ID);

    Page getOfficeList(@Param("searchValue")String searchValue, Page page);

    Integer updateOffice(Office office);

    Integer deleteOffice(String ID);
	
}
