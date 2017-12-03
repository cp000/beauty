/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.modules.system.impl;

import com.meixiang.beauty.common.constant.StatusConstant;
import com.meixiang.beauty.common.dto.system.UserInfoDTO;
import com.meixiang.beauty.common.dto.wechat.WeixinTokenDTO;
import com.meixiang.beauty.modules.system.api.SystemService;
import com.meixiang.beauty.sys.dao.SystemDao;
import com.meixiang.beauty.sys.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * 系统管理，安全相关实体的管理类,包括用户、角色、菜单.
 * @author ThinkGem
 * @version 2013-12-05
 */
@Service
@Transactional(readOnly = true)
public class SystemServiceImpl implements SystemService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SystemDao systemDao;

	@Autowired
	protected MongoTemplate mongoTemplate;


	//获取微信的token
	@Override
	public WeixinTokenDTO getWeixinParameter(){
		Query query = new Query().addCriteria(Criteria.where("weixinFlag").is("businessOnlineOperation"));
		List<WeixinTokenDTO> data = mongoTemplate.find(query, WeixinTokenDTO.class,"weixinParameter");
		return data.get(0);
	}

	@Override
	public String sendMessage(String phoneNum) {
		try {
			String num = null;//DaHanTricomSMSMessageUtil.sendIdentifying(phoneNum);
			return StatusConstant.SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return StatusConstant.FAILURE;
		}
	}

	@Override
	public UserInfoDTO addSuggestion(String userId, String suggestion) {
		return null;
	}

}
