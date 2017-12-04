package com.meixiang.beauty.modules.transaction.api;

import com.meixiang.beauty.common.dto.transaction.BusinessOrderDTO;
import com.meixiang.beauty.common.dto.transaction.UserOrderAddressDTO;

import java.util.List;

/**
 * Created by zbm84 on 2017/5/10.
 */
public interface TransactionService {

    List<BusinessOrderDTO> getUserUnPayOrderInBuyCart(String userId);

    String getUserUnPayOrderNum(String userId);

    void updateProductNumInBusinessOrder(String userId, String businessOrderId,String operateType) throws Exception;

    void updateBusinessOrderStatus(List<BusinessOrderDTO> businessOrderDTOList) throws Exception;

    List<BusinessOrderDTO> getBusinessOrderList(String userId, String status);

    List<UserOrderAddressDTO> getUserAddressList(String userId);

    void addUserAddress(UserOrderAddressDTO userOrderAddressDTO) throws Exception;

    void updateUserAddress(UserOrderAddressDTO userOrderAddressDTO) throws Exception;

    void createBusinessOrder(BusinessOrderDTO businessOrderDTO) throws Exception;
}
