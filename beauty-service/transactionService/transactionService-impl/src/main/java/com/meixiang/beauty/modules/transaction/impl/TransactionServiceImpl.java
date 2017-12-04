package com.meixiang.beauty.modules.transaction.impl;

import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.UserOrderAddressDTO;
import com.meixiang.beauty.modules.transaction.api.TransactionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/10.
 */

@Service
@Transactional(readOnly = false)
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
    public void updateProductNumInBusinessOrder(String userId, String businessOrderId,String operateType) throws Exception{

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
    @Transactional(rollbackFor = Exception.class)
    public void addUserAddress(UserOrderAddressDTO userOrderAddressDTO) {

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO) throws Exception{

    }

    @Override
    public void createBusinessOrder(BusinessOrderDTO businessOrderDTO) throws Exception{

    }
}
