package com.meixiang.beauty.common.dto.transaction;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class UserOrderAddressDTO {

    @JSONField(name = "sysUserId")
    private String sysUserId;

    @JSONField(name = "province")
    private String province;

    @JSONField(name = "city")
    private String city;

    @JSONField(name = "detailAddress")
    private String detailAddress;

    @JSONField(name = "status")
    private String status;

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetailAddress() {
        return detailAddress;
    }

    public void setDetailAddress(String detailAddress) {
        this.detailAddress = detailAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
