package com.example.lsproject.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {

    private String token;
    private String yhxlh;// 用户序列号（用户id）
    private String yhtx;// 头像（base64字符串）
    private String yhmc;// 用户姓名
    private String usertype;// 标识身份
    private String usertypeName;// 身份名称
    private String sjhm;// 手机号
    private String email;// 邮箱

    public LoginBean() {
        super();
    }

    public LoginBean(String token, String yhxlh, String yhtx, String yhmc, String usertype, String usertypeName, String sjhm, String email) {
        this.token = token;
        this.yhxlh = yhxlh;
        this.yhtx = yhtx;
        this.yhmc = yhmc;
        this.usertype = usertype;
        this.usertypeName = usertypeName;
        this.sjhm = sjhm;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getYhxlh() {
        return yhxlh;
    }

    public void setYhxlh(String yhxlh) {
        this.yhxlh = yhxlh;
    }

    public String getYhtx() {
        return yhtx;
    }

    public void setYhtx(String yhtx) {
        this.yhtx = yhtx;
    }

    public String getYhmc() {
        return yhmc;
    }

    public void setYhmc(String yhmc) {
        this.yhmc = yhmc;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsertypeName() {
        return usertypeName;
    }

    public void setUsertypeName(String usertypeName) {
        this.usertypeName = usertypeName;
    }

    public String getSjhm() {
        return sjhm;
    }

    public void setSjhm(String sjhm) {
        this.sjhm = sjhm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "token='" + token + '\'' +
                ", yhxlh='" + yhxlh + '\'' +
                ", yhtx='" + yhtx + '\'' +
                ", yhmc='" + yhmc + '\'' +
                ", usertype='" + usertype + '\'' +
                ", usertypeName='" + usertypeName + '\'' +
                ", sjhm='" + sjhm + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
