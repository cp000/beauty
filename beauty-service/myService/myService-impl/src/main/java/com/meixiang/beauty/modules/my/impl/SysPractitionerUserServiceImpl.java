package com.meixiang.beauty.modules.my.impl;

import com.meixiang.beauty.common.dto.practitioner.Settings.SysPractitionerUserDTO;
import com.meixiang.beauty.modules.my.service.SysPractitionerUserService;
import com.meixiang.beauty.sys.dao.SysPractitionerUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zbm84 on 2017/5/11.
 */
@Service
@Transactional(readOnly = false)
public class SysPractitionerUserServiceImpl implements SysPractitionerUserService {

    @Autowired
    private SysPractitionerUserDao sysPractitionerUserDao;

    @Override
    public int updateSysPractitionerUser(SysPractitionerUserDTO sysPractitionerUser) {
        return sysPractitionerUserDao.updateSysPractitionerUser(sysPractitionerUser);
    }

}