/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.dto.QuestionnaireInfoDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

/**
 * 信息DAO接口
 */
@MyBatisDao
@Repository
public interface QuestionnaireInfoDao {



	 int insert(QuestionnaireInfoDTO questionnaireInfoDTO);

	 QuestionnaireInfoDTO findAllList(QuestionnaireInfoDTO questionnaireInfoDTO);

}
