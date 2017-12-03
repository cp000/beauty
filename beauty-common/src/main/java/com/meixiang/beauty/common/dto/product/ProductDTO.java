package com.meixiang.beauty.common.dto.product;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.common.persistence.DataEntity;

public class ProductDTO<T> {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "productName")
    private String productName;

    //type为course表示产品类型课程类，offline表示为线下产品
    @JSONField(name = "type")
    private String type;

    @JSONField(name = "description")
    private String description;

    @JSONField(name = "firstUrl")
    private String firstUrl;

    @JSONField(name = "price")
    private String price;

    @JSONField(name = "productExtension")
    private T productExtension;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFirstUrl() {
        return firstUrl;
    }

    public void setFirstUrl(String firstUrl) {
        this.firstUrl = firstUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public T getProductExtension() {
        return productExtension;
    }

    public void setProductExtension(T productExtension) {
        this.productExtension = productExtension;
    }
}