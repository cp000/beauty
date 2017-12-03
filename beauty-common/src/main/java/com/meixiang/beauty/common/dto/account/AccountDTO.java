package com.meixiang.beauty.common.dto.account;

import com.alibaba.fastjson.annotation.JSONField;

public class AccountDTO {

    @JSONField(name = "sysUserId")
    private String sysUserId;

    @JSONField(name = "userOpenId")
    private String userOpenId;

    @JSONField(name = "balance")
    private String balance;

    @JSONField(name = "score")
    private String score;

    @JSONField(name = "status")
    private String status;

    @JSONField(name = "updateTime")
    private String updateTime;

    public String getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserOpenId() {
        return userOpenId;
    }

    public void setUserOpenId(String userOpenId) {
        this.userOpenId = userOpenId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}