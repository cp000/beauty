/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;

import beauty.common.persistence.Page;
import beauty.common.persistence.annotation.MyBatisDao;
import beauty.modules.sys.entity.Office;
import org.apache.ibatis.annotations.Param;


@MyBatisDao
public interface OfficeDao {

    int insertOffice(Office sysHospitalUserDTO);

    Office getOfficeByID(String ID);

    Page getOfficeList(@Param("searchValue")String searchValue, Page page);

    Integer updateOffice(Office office);

    Integer deleteOffice(String ID);
	
}
