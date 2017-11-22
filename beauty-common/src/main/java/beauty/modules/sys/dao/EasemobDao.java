/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;

import beauty.common.persistence.CrudDao;
import beauty.common.persistence.annotation.MyBatisDao;
import beauty.modules.sys.entity.Easemob;
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
