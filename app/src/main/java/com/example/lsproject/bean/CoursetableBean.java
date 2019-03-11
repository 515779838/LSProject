package com.example.lsproject.bean;

public class CoursetableBean {
    private String section;
    private String teaName;
    private String gradeClass;

    public CoursetableBean() {
        super();
    }

    public CoursetableBean(String section, String teaName, String gradeClass) {
        this.section = section;
        this.teaName = teaName;
        this.gradeClass = gradeClass;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getGradeClass() {
        return gradeClass;
    }

    public void setGradeClass(String gradeClass) {
        this.gradeClass = gradeClass;
    }

    @Override
    public String toString() {
        return "CoursetableBean{" +
                "section='" + section + '\'' +
                ", teaName='" + teaName + '\'' +
                ", gradeClass='" + gradeClass + '\'' +
                '}';
    }
}
