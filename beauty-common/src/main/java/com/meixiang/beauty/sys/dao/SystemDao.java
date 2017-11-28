/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;


import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * 用户DAO接口
 * @author Frank
 * @version 2014-05-16
 */
@MyBatisDao
@Repository 
public interface SystemDao {

	HashMap<String,Object> getWechatParameter();

}
