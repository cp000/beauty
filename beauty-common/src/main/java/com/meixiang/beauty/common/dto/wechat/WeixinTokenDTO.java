package com.meixiang.beauty.common.dto.wechat;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by zbm84 on 2017/6/7.
 */
public class WeixinTokenDTO {

    @JSONField(name = "token")
    private String token;

    @JSONField(name = "ticket")
    private String ticket;

    @JSONField(name = "createDate")
    private Date createDate;

    @JSONField(name = "weixinFlag")
    private String weixinFlag;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getWeixinFlag() {
        return weixinFlag;
    }

    public void setWeixinFlag(String weixinFlag) {
        this.weixinFlag = weixinFlag;
    }
}
