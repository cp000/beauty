package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/5/25.
 */
@MyBatisDao
@Repository
public interface HealthDataDao {

    public List getThirdPartUserInfo();
}
