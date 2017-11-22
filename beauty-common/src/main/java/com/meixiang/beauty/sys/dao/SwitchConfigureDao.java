package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.sys.entity.SwitchConfigure;

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
