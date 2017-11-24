package com.meixiang.beauty.modules.training.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.modules.training.entity.UserQRCode;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@MyBatisDao
public interface UserQRCodeDao {
/**
 * 根据用户OpenID添加推广码
 * @param usercode
 * @return
 */
	int insertUserQRCode(UserQRCode usercode);
	
	/**
	 * 根据OpenID获取QRCode
	 * @param openid
	 * @return
	 */
	Map<String,Object> getQRCodeFromOpenid(@Param("openid") String openid);
	
	
	List<Map<String,Object>> getShareFromOpenid(Map<String, Object> m);
	
	
	List<Map<String,Object>> getShareFromOpenidAndAPITime(Map<String, Object> m);

	List<String> getFollowerListByMarketer(@Param("marketer") String marketer);
}
