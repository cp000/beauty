package com.meixiang.beauty.modules.account.api;


import com.meixiang.beauty.common.dto.account.AccountDTO;

/**
 * Created by sunxiao on 2017/6/26.
 */
public interface AccountService {

    AccountDTO getUserAccountInfo(String userId);

}
