package com.example.lsproject.bean;

/**
 * Created by caoyingfu on 2017/8/23.
 */

public class SelectBean {

    private String id;
    private String name;
    private String code;
    private String gradeCode;
    private String classCode;
    private String other1;
    private String other2;
    private String other3;
    private String other4;
    private String other5;
    private String other6;
    private String other7;
    private String other8;
    private String other9;

    private boolean isCheck = false;// 多选check使用

    public String getId() {
        return id;
    }

    public String getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(String gradeCode) {
        this.gradeCode = gradeCode;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOther1() {
        return other1;
    }

    public void setOther1(String other1) {
        this.other1 = other1;
    }

    public String getOther2() {
        return other2;
    }

    public void setOther2(String other2) {
        this.other2 = other2;
    }

    public String getOther3() {
        return other3;
    }

    public void setOther3(String other3) {
        this.other3 = other3;
    }

    public String getOther4() {
        return other4;
    }

    public void setOther4(String other4) {
        this.other4 = other4;
    }

    public String getOther5() {
        return other5;
    }

    public void setOther5(String other5) {
        this.other5 = other5;
    }

    public String getOther6() {
        return other6;
    }

    public void setOther6(String other6) {
        this.other6 = other6;
    }

    public String getOther7() {
        return other7;
    }

    public void setOther7(String other7) {
        this.other7 = other7;
    }

    public String getOther8() {
        return other8;
    }

    public void setOther8(String other8) {
        this.other8 = other8;
    }

    public String getOther9() {
        return other9;
    }

    public void setOther9(String other9) {
        this.other9 = other9;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    @Override
    public String toString() {
        return "SelectBean{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", gradeCode='" + gradeCode + '\'' +
                ", classCode='" + classCode + '\'' +
                ", other1='" + other1 + '\'' +
                ", other2='" + other2 + '\'' +
                ", other3='" + other3 + '\'' +
                ", other4='" + other4 + '\'' +
                ", other5='" + other5 + '\'' +
                ", other6='" + other6 + '\'' +
                ", other7='" + other7 + '\'' +
                ", other8='" + other8 + '\'' +
                ", other9='" + other9 + '\'' +
                ", isCheck=" + isCheck +
                '}';
    }
}
