package beauty.modules.sys.dao;

import beauty.common.persistence.annotation.MyBatisDao;
import beauty.modules.sys.entity.SwitchConfigure;

import java.util.Map;

/**
 * 开关配置DAO接口
 * @author sunxiao
 * @version 2016-06-13
 */
@MyBatisDao
public interface SwitchConfigureDao {

    SwitchConfigure getUmbrellaSwitch(Map map);
}
