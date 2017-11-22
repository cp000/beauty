/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.dto.practitioner.Settings.SysHospitalUserDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 会员用户DAO接口
 * @author 张博
 * @version 2017年5月27日
 */
@MyBatisDao
@Repository
public interface SysHospitalUserDao{

    int insertSysHospitalUser(SysHospitalUserDTO sysHospitalUserDTO);

    SysHospitalUserDTO getSysHospitalUserByUserID(String sysUserID);

    SysHospitalUserDTO getSysHospitalUserByEasemobID(String hospitalID);

    Integer updateLoginToken(SysHospitalUserDTO sysHospitalUserDTO);

    Page getSysHospitalUserList(@Param("searchValue")String searchValue,Page page);

    Integer updateSysHospitalUser(SysHospitalUserDTO sysHospitalUserDTO);

    List<SysHospitalUserDTO> getSysHospitalUserByInfo(SysHospitalUserDTO sysHospitalUserDTO);
}
