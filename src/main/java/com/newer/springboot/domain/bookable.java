package com.newer.springboot.domain;

import java.io.Serializable;
import java.util.Date;

public class bookable implements Serializable {

    private static final long serialVersionUID = -8573959892015258568L;

    //主键自增
    private Integer bid;
    //医生id
    private Integer doid;
    //排班日期
    private Date bdate;
    //时间段
    private int starttime;
    //预约用户编号？？？
    private int userd;
    //网上可预约数量
    private int bnum;
    //网上预约人数
    private int ynum;
    //现场预约人数
    private int xcynum;
    //备用1
    private String by1;
    //备用2
    private Integer by2;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public Date getBdate() {
        return bdate;
    }

    public void setBdate(Date bdate) {
        this.bdate = bdate;
    }

    public int getStarttime() {
        return starttime;
    }

    public void setStarttime(int starttime) {
        this.starttime = starttime;
    }

    public int getUserd() {
        return userd;
    }

    public void setUserd(int userd) {
        this.userd = userd;
    }

    public int getBnum() {
        return bnum;
    }

    public void setBnum(int bnum) {
        this.bnum = bnum;
    }

    public int getYnum() {
        return ynum;
    }

    public void setYnum(int ynum) {
        this.ynum = ynum;
    }

    public int getXcynum() {
        return xcynum;
    }

    public void setXcynum(int xcynum) {
        this.xcynum = xcynum;
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