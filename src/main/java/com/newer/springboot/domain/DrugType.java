package com.newer.springboot.domain;

public class DrugType {
    private Integer dyid;
    private String dyname;
    private String dystate;
    private String by1;
    private Integer by2;

    public DrugType() {
    }

    public Integer getDyid() {
        return dyid;
    }

    public void setDyid(Integer dyid) {
        this.dyid = dyid;
    }

    public String getDyname() {
        return dyname;
    }

    public void setDyname(String dyname) {
        this.dyname = dyname;
    }

    public String getDystate() {
        return dystate;
    }

    public void setDystate(String dystate) {
        this.dystate = dystate;
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

    @Override
    public String toString() {
        return "DrugType{" +
                "dyid=" + dyid +
                ", dyname='" + dyname + '\'' +
                ", dystate='" + dystate + '\'' +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
