package com.mailMis.vo;

import java.io.Serializable;

/**
 * 搜索参数
 * Created by ArnoldLee on 17/9/29.
 */
public class SearchParamVo implements Serializable {

    //韩国/收件人
    private String kUserName;

    //韩国/电话
    private String kPhone;

    public String getkUserName() {
        return kUserName;
    }

    public void setkUserName(String kUserName) {
        this.kUserName = kUserName;
    }

    public String getkPhone() {
        return kPhone;
    }

    public void setkPhone(String kPhone) {
        this.kPhone = kPhone;
    }
}
