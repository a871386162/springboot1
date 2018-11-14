package com.newer.springboot.domain;

import java.io.Serializable;

public class Drug implements Serializable {

    private static final long serialVersionUID = -2121817671611704707L;
    private Integer drid;
    private Integer dyid;
    private DrugType drugType;
    private String dename;
    private String drname;
    private double drsum;
    private double drprice;
    private Integer drstate;
    private String by1;
    private Integer by2;


    public Drug() {
    }

    public Drug(Integer drid, Integer dyid, String drname, double drsum, double drprice) {
        this.drid = drid;
        this.dyid = dyid;
        this.drname = drname;
        this.drsum = drsum;
        this.drprice = drprice;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public Integer getDrid() {
        return drid;
    }

    public void setDrid(Integer drid) {
        this.drid = drid;
    }

    public Integer getDyid() {
        return dyid;
    }

    public void setDyid(Integer dyid) {
        this.dyid = dyid;
    }

    public DrugType getDrugType() {
        return drugType;
    }

    public void setDrugType(DrugType drugType) {
        this.drugType = drugType;
    }


    public String getDrname() {
        return drname;
    }

    public void setDrname(String drname) {
        this.drname = drname;
    }

    public double getDrsum() {
        return drsum;
    }

    public void setDrsum(double drsum) {
        this.drsum = drsum;
    }

    public double getDrprice() {
        return drprice;
    }

    public void setDrprice(double drprice) {
        this.drprice = drprice;
    }

    public Integer getDrstate() {
        return drstate;
    }

    public void setDrstate(Integer drstate) {
        this.drstate = drstate;
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
        return "Drug{" +
                "drid=" + drid +
                ", dyid=" + dyid +
                ", drugType=" + drugType +
                ", dename='" + dename + '\'' +
                ", drname='" + drname + '\'' +
                ", drsum=" + drsum +
                ", drprice=" + drprice +
                ", drstate=" + drstate +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
