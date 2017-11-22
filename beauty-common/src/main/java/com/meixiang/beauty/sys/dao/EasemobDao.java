/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.CrudDao;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.sys.entity.Easemob;
import org.springframework.stereotype.Repository;

/**
 * 用户DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
@Repository
public interface EasemobDao extends CrudDao<Easemob> {

	Easemob getEasemobToken();

	int updateEasemobToken(Easemob easemob);



}
