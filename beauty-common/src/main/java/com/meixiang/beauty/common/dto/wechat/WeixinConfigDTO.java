package com.meixiang.beauty.common.dto.wechat;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by zbm84 on 2017/6/7.
 */
public class WeixinConfigDTO {

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "jsapi_ticket")
    private String jsapi_ticket;

    @JSONField(name = "nonceStr")
    private String nonceStr;

    @JSONField(name = "timestamp")
    private String timestamp;

    @JSONField(name = "signature")
    private String signature;

    @JSONField(name = "appid")
    private String appid;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJsapi_ticket() {
        return jsapi_ticket;
    }

    public void setJsapi_ticket(String jsapi_ticket) {
        this.jsapi_ticket = jsapi_ticket;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }
}
