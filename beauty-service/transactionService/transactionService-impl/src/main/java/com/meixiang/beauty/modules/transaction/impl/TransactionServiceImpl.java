package com.meixiang.beauty.modules.transaction.impl;

import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.UserOrderAddressDTO;
import com.meixiang.beauty.modules.transaction.api.TransactionService;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/10.
 */
public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<BusinessOrderDTO> getUserUnPayOrderInBuyCart(String userId) {
        return null;
    }

    @Override
    public String getUserUnPayOrderNum(String userId) {
        return null;
    }

    @Override
    public String addProductNumInBusinessOrder(String userId, String businessOrderId) {
        return null;
    }

    @Override
    public void updateBusinessOrderStatus(List<BusinessOrderDTO> businessOrderDTOList) throws Exception{
    }

    @Override
    public List<BusinessOrderDTO> getBusinessOrderList(String userId, String status) {
        return null;
    }

    @Override
    public List<UserOrderAddressDTO> getUserAddressList(String userId) {
        return null;
    }

    @Override
    public void addUserAddress(UserOrderAddressDTO userOrderAddressDTO) {

    }

    @Override
    public void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO) {

    }
}
