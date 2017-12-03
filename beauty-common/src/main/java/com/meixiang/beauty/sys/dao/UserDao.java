/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import java.util.List;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import org.springframework.stereotype.Repository;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;

/**
 * 用户DAO接口
 * @author ThinkGem
 * @version 2014-05-16
 */
@MyBatisDao
@Repository
public interface UserDao {

	List<UserInfoDTO> getUserByInfo(UserInfoDTO userInfoDTO);

	void updateUserInfo(UserInfoDTO userInfoDTO);

	void insertUserInfo(UserInfoDTO userInfoDTO);

}
