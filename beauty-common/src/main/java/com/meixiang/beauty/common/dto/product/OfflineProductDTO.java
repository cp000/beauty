package com.meixiang.beauty.common.dto.product;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

public class OfflineProductDTO {

    @JSONField(name = "offlineProductName")
    private String offlineProductName;

    @JSONField(name = "brand")
    private String brand;

    @JSONField(name = "offlineProductType")
    private String offlineProductType;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "description")
    private String firstUrl;

    @JSONField(name = "listPic")
    private List<String> listPic;

    @JSONField(name = "spec")
    private List<String> spec;

    @JSONField(name = "services")
    private List<String> services;

    @JSONField(name = "detailPic")
    private String detailPic;

    @JSONField(name = "sendAddress")
    private String sendAddress;

    public String getOfflineProductName() {
        return offlineProductName;
    }

    public void setOfflineProductName(String offlineProductName) {
        this.offlineProductName = offlineProductName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOfflineProductType() {
        return offlineProductType;
    }

    public void setOfflineProductType(String offlineProductType) {
        this.offlineProductType = offlineProductType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstUrl() {
        return firstUrl;
    }

    public void setFirstUrl(String firstUrl) {
        this.firstUrl = firstUrl;
    }

    public List<String> getListPic() {
        return listPic;
    }

    public void setListPic(List<String> listPic) {
        this.listPic = listPic;
    }

    public List<String> getSpec() {
        return spec;
    }

    public void setSpec(List<String> spec) {
        this.spec = spec;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getDetailPic() {
        return detailPic;
    }

    public void setDetailPic(String detailPic) {
        this.detailPic = detailPic;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
    }
}