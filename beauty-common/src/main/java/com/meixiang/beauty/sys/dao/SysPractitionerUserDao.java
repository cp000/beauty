/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.dto.practitioner.Settings.SysPractitionerUserDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医护用户DAO接口
 *
 * @author
 * @version 2017年5月9日
 */
@MyBatisDao
@Repository
public interface SysPractitionerUserDao {

    int insertSysPractitionerUser(SysPractitionerUserDTO sysPractitionerUser);

    int updateSysPractitionerUser(SysPractitionerUserDTO sysPractitionerUser);

    SysPractitionerUserDTO getSysPractitioner(String sysUserID);

    Integer updateLoginToken(SysPractitionerUserDTO sysPractitionerUser);

    SysPractitionerUserDTO getSysPractitionerByEasemobID(String easemobID);

    SysPractitionerUserDTO getSysPractitionerByID(String id);

    Page getDoctorListByHospitalID(@Param("sysHospitalID") String sysHospitalID, Page page, @Param("searchValue") String searchValue, @Param("type") String type);

    Integer getDoctorListCountByHospitalID(@Param("sysHospitalID") String sysHospitalID);

    List<String> doctorAndNurseStatistics(String title);
}
