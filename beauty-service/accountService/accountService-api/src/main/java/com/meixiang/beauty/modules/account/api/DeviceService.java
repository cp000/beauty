package com.meixiang.beauty.modules.account.api;

import com.meixiang.beauty.common.dto.hospital.DeviceDTO;
import com.meixiang.beauty.common.persistence.Page;
import net.sf.json.JSONArray;


/**
 * Created by sunxiao on 2017/6/20.
 */
public interface DeviceService {

    void operDevice(DeviceDTO deviceDTO) throws Exception;

    void findDeviceList(String param, Page page) throws Exception;

    JSONArray getStatisticsDevice() throws Exception;
}
