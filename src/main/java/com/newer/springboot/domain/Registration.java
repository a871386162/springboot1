package com.newer.springboot.domain;

import java.io.Serializable;

public class Registration implements Serializable {
    private static final long serialVersionUID = 3134470817175621950L;

    private Integer rid;

    private  Integer cid;

    private  Integer bid;

    private  Integer snum;

    private  Integer state;

    private  String by1;

    private  Integer by2;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getSnum() {
        return snum;
    }

    public void setSnum(Integer snum) {
        this.snum = snum;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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
