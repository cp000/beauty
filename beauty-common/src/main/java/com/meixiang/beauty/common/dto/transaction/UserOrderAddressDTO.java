package com.meixiang.beauty.common.dto.transaction;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.common.dto.product.ProductDTO;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class UserOrderAddressDTO {

    @JSONField(name = "sysUserId")
    private String sysUserId;

    @JSONField(name = "businessOrderId")
    private String businessOrderId;

    @JSONField(name = "type")
    private String type;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "businessProductNum")
    private String businessProductNum;

    @JSONField(name = "userAddress")
    private String userAddress;

    @JSONField(name = "businessProduct")
    private ProductDTO businessProduct;

    @JSONField(name = "businessOrderAddress")
    private ProductDTO businessOrderAddress;

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getBusinessOrderId() {
        return businessOrderId;
    }

    public void setBusinessOrderId(String businessOrderId) {
        this.businessOrderId = businessOrderId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessProductNum() {
        return businessProductNum;
    }

    public void setBusinessProductNum(String businessProductNum) {
        this.businessProductNum = businessProductNum;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public ProductDTO getBusinessProduct() {
        return businessProduct;
    }

    public void setBusinessProduct(ProductDTO businessProduct) {
        this.businessProduct = businessProduct;
    }

    public ProductDTO getBusinessOrderAddress() {
        return businessOrderAddress;
    }

    public void setBusinessOrderAddress(ProductDTO businessOrderAddress) {
        this.businessOrderAddress = businessOrderAddress;
    }
}
