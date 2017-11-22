package com.meixiang.beauty.sys.dao;

import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import com.meixiang.beauty.common.dto.practitioner.healthService.EmptyNestElderBaseInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/7/8.
 */
@MyBatisDao
@Repository
public interface EmptyNestElderBaseInfoDao {

    public void importEmptyElderBaseInfo(EmptyNestElderBaseInfo vo);

    public List<EmptyNestElderBaseInfo> getAllEmptyElderBaseInfo();
}
