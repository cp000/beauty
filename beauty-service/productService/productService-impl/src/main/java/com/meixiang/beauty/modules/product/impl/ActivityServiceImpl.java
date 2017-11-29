package com.meixiang.beauty.modules.product.impl;

import com.alibaba.fastjson.JSON;
import com.meixiang.beauty.common.dto.activity.ActivityDTO;
import com.meixiang.beauty.common.dto.activity.ActivityDiscussDTO;
import com.meixiang.beauty.common.dto.activity.ActivityEasemobGroupInfo;
import com.meixiang.beauty.common.dto.activity.AttendedActivityDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.SysElderUserDTO;
import com.meixiang.beauty.common.dto.practitioner.Settings.SysHospitalUserDTO;
import com.meixiang.beauty.common.persistence.Page;
import com.meixiang.beauty.modules.product.DTO.ActivityEasemobGroupInfoDTO;
import com.meixiang.beauty.modules.product.DTO.ActivityEasemobGroupUserDTO;
import com.meixiang.beauty.modules.product.api.ActivityService;
import com.meixiang.beauty.modules.product.dao.*;
import com.meixiang.beauty.modules.product.entity.*;
import com.meixiang.beauty.sys.dao.SysElderUserDao;
import com.meixiang.beauty.sys.dao.SysHospitalUserDao;
import com.meixiang.beauty.sys.dao.UserDao;
import com.meixiang.beauty.sys.entity.User;
import com.meixiang.beauty.sys.service.EasemobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by zbm84 on 2017/7/24.
 */
@Service
@Transactional(readOnly = false)
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private SysHospitalUserDao sysHospitalUserDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private SysElderUserDao sysElderUserDao;

    @Override
    public void sendReservationMessage() {
    }

}
