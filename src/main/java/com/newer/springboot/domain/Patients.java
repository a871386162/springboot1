package com.newer.springboot.domain;

import java.io.Serializable;

public class Patients implements Serializable {
    private static final long serialVersionUID = 8394289422285509668L;

    private Integer pid;
    private String pname;
    private String gender;
    private String sex;
    private String phone;
    private String idCard;
    private String pwd;
    private String medCard;
    private String email;
    private String by1;
    private String by2;

    public Patients() {
    }

    public Patients(Integer pid, String pname, String gender,String sex, String phone, String idCard, String pwd,String medCard, String email, String by1, String by2) {
        this.pid = pid;
        this.pname = pname;
        this.gender = gender;
        this.sex = sex;
        this.phone = phone;
        this.idCard = idCard;
        this.pwd = pwd;
        this.medCard = medCard;
        this.email = email;
        this.by1 = by1;
        this.by2 = by2;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getMedCard() {
        return medCard;
    }

    public void setMedCard(String medCard) {
        this.medCard = medCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public String getBy2() {
        return by2;
    }

    public void setBy2(String by2) {
        this.by2 = by2;
    }

    @Override
    public String toString() {
        return "Patients{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", gender='" + gender + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", idCard='" + idCard + '\'' +
                ", pwd='" + pwd + '\'' +
                ", medCard='" + medCard + '\'' +
                ", email='" + email + '\'' +
                ", by1='" + by1 + '\'' +
                ", by2='" + by2 + '\'' +
                '}';
    }
}
