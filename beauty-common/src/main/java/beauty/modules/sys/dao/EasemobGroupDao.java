/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package beauty.modules.sys.dao;

import beauty.common.persistence.annotation.MyBatisDao;
import beauty.modules.sys.entity.EasemobGroup;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医护用户DAO接口
 * @author
 * @version 2017年5月9日
 */
@MyBatisDao
@Repository
public interface EasemobGroupDao {

    int insertEasemobGroup(EasemobGroup easemobGroup);

    EasemobGroup getEasemobGroupByGroupID(@Param("easemobGroupID") String groupID);

    EasemobGroup getEasemobGroupIDByElderID(@Param("elderEasemobID") String elderEasemobID);

    List<EasemobGroup> getEasemobGroupByDoctorEasemobID(@Param("doctorEasemobID") String doctorEasemobID);

    int updateEasemobGroup(EasemobGroup easemobGroup);

}
