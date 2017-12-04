package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;
import jxl.write.DateTime;

import java.util.Date;

public class UserInfoDTO {

    @JSONField(name = "id")
    private String id;

    @JSONField(name = "nickname")
    private String nickname;

    @JSONField(name = "password")
    private String password;

    @JSONField(name = "email")
    private String email;

    @JSONField(name = "identifyNumber")
    private String identifyNumber;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "userType")
    private String userType;

    @JSONField(name = "userOpenid")
    private String userOpenid;

    @JSONField(name = "parentUserId")
    private String parentUserId;

    @JSONField(name = "weixinAttentionStatus")
    private String weixinAttentionStatus;

    @JSONField(name = "photo")
    private String photo;

    @JSONField(name = "loginIp")
    private String login_ip;

    @JSONField(name = "loginDate")
    private Date login_date;

    @JSONField(name = "createDate")
    private Date create_date;

    @JSONField(name = "delFlag")
    private String del_flag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentifyNumber() {
        return identifyNumber;
    }

    public void setIdentifyNumber(String identifyNumber) {
        this.identifyNumber = identifyNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserOpenid() {
        return userOpenid;
    }

    public void setUserOpenid(String userOpenid) {
        this.userOpenid = userOpenid;
    }

    public String getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(String parentUserId) {
        this.parentUserId = parentUserId;
    }

    public String getWeixinAttentionStatus() {
        return weixinAttentionStatus;
    }

    public void setWeixinAttentionStatus(String weixinAttentionStatus) {
        this.weixinAttentionStatus = weixinAttentionStatus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip;
    }

    public Date getLogin_date() {
        return login_date;
    }

    public void setLogin_date(Date login_date) {
        this.login_date = login_date;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }
}