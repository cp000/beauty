/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;


import java.util.HashMap;

import org.springframework.stereotype.Repository;

import beauty.common.persistence.annotation.MyBatisDao;

/**
 * 用户DAO接口
 * @author Frank
 * @version 2014-05-16
 */
@MyBatisDao
@Repository 
public interface SystemDao {

	HashMap<String,Object> getWechatParameter();

    HashMap<String,Object> getDoctorWechatParameter();
}
