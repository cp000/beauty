package com.meixiang.beauty.common.dto.system;

import com.alibaba.fastjson.annotation.JSONField;
import com.meixiang.beauty.common.persistence.DataEntity;

import java.util.Date;

/**
 * Created by zbm84 on 2017/8/3.
 */
public class ValidateCodeDTO {

    @JSONField(name = "mobile")
    private String mobile;

    @JSONField(name = "code")
    private String code;

    @JSONField(name = "createDate")
    private String createDate;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
