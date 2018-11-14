package com.newer.springboot.domain;

import java.io.Serializable;
import java.util.Date;

public class Cards implements Serializable {
    private static final long serialVersionUID = -7199622823318891785L;
    private Integer cid;
    private String pname;
    private String gender;
    private String Phone;
    private String idcard;
    private String pwd;
    private Double ramaining;
    private Date newdate;
    private Integer doexist;
    private  String by1;
    private Integer by2;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Double getRamaining() {
        return ramaining;
    }

    public void setRamaining(Double ramaining) {
        this.ramaining = ramaining;
    }

    public Date getNewdate() {
        return newdate;
    }

    public void setNewdate(Date newdate) {
        this.newdate = newdate;
    }

    public Integer getDoexist() {
        return doexist;
    }

    public void setDoexist(Integer doexist) {
        this.doexist = doexist;
    }

    public String getBy1() {
        return by1;
    }

    public void setBy1(String by1) {
        this.by1 = by1;
    }

    public Integer getBy2() {
        return by2;
    }

    public void setBy2(Integer by2) {
        this.by2 = by2;
    }
}
