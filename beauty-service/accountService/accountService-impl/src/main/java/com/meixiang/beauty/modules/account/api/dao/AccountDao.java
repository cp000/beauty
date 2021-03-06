package com.meixiang.beauty.modules.account.api.dao;

import com.meixiang.beauty.common.dto.hospital.DeviceDTO;
import com.meixiang.beauty.common.persistence.annotation.MyBatisDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sunxiao on 2017/6/20.
 */
@MyBatisDao
@Repository
public interface AccountDao {

    void addDevice(DeviceDTO deviceDTO);

    void updateDevice(DeviceDTO deviceDTO);

    void delDevice(Integer id);

    List<String> selectAllType();

    List getDeviceByInfo(DeviceDTO deviceDTO);

    int getDeviceNum(String type);

    int deviceBindNum(String type);
}
