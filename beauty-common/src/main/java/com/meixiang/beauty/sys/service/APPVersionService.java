/**
 * Copyright &copy; 2012-2013 <a href="httparamMap://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.service;

import com.meixiang.beauty.common.dto.APPVersionDTO;
import com.meixiang.beauty.sys.dao.APPVersionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志Service
 * @author ThinkGem
 * @version 2014-05-16
 */
@Service
@Transactional(readOnly = true)
public class APPVersionService{

	@Autowired
	private APPVersionDao appVersionDao;

	public APPVersionDTO get(String source){
		return  appVersionDao.get(source);
	}

	public Integer insert(APPVersionDTO appVersionDTO){
		try {
			appVersionDao.insert(appVersionDTO);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return  0;
		}
	}
	
}
