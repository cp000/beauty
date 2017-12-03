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

    @JSONField(name = "identify_number")
    private String identify_number;

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "user_type")
    private String user_type;

    @JSONField(name = "user_openid")
    private String user_openid;

    @JSONField(name = "parent_user_id")
    private String parent_user_id;

    @JSONField(name = "weixin_attention_status")
    private String weixin_attention_status;

    @JSONField(name = "photo")
    private String photo;

    @JSONField(name = "login_ip")
    private String login_ip;

    @JSONField(name = "login_date")
    private Date login_date;

    @JSONField(name = "create_date")
    private Date create_date;

    @JSONField(name = "del_flag")
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

    public String getIdentify_number() {
        return identify_number;
    }

    public void setIdentify_number(String identify_number) {
        this.identify_number = identify_number;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getUser_openid() {
        return user_openid;
    }

    public void setUser_openid(String user_openid) {
        this.user_openid = user_openid;
    }

    public String getParent_user_id() {
        return parent_user_id;
    }

    public void setParent_user_id(String parent_user_id) {
        this.parent_user_id = parent_user_id;
    }

    public String getWeixin_attention_status() {
        return weixin_attention_status;
    }

    public void setWeixin_attention_status(String weixin_attention_status) {
        this.weixin_attention_status = weixin_attention_status;
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