/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;

import beauty.common.dto.QuestionnaireInfoDTO;
import beauty.common.persistence.annotation.MyBatisDao;
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
