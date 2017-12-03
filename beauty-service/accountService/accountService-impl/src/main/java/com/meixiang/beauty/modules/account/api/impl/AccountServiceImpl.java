package com.meixiang.beauty.modules.account.api.impl;

import com.meixiang.beauty.common.dto.account.AccountDTO;
import com.meixiang.beauty.modules.account.api.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sunxiao on 2017/6/26.
 */

@Service
@Transactional(readOnly = false)
public class AccountServiceImpl implements AccountService {

    @Autowired
    MongoTemplate mongoTemplate;


    @Override
    public AccountDTO getUserAccountInfo(String userId) {
        return null;
    }
}
