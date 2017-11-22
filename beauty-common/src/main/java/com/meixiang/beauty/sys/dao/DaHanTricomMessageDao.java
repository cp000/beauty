/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 信息DAO接口
 */
@MyBatisDao
@Repository
public interface DaHanTricomMessageDao {


	//插入验证码信息
	public int insertIdentifying(@Param(value="PhonNum") String PhonNum, @Param(value="Identifying") String Identifying);

	//查询验证码是否正确
	public int searchIdentify(@Param(value="PhonNum") String PhonNum, @Param(value="Identifying") String Identifying);
	

}
