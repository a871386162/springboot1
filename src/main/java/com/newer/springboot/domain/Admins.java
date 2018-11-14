package com.newer.springboot.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Admins implements Serializable {
    private static final long serialVersionUID = 9209458611561383275L;
    private Integer aid;
    private String aname;
    private String pwd;
    private int state;
    private String email;
    private Date lastPassworldResetDate;
    private Integer aexist; //状态 0-停用 1-再用
    private Date loginTime;
    private Integer doId;
    private String by1;
    private Integer by2;
    private List<Authority> authorities;


    public Admins() {
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLastPassworldResetDate() {
        return lastPassworldResetDate;
    }

    public void setLastPassworldResetDate(Date lastPassworldResetDate) {
        this.lastPassworldResetDate = lastPassworldResetDate;
    }

    public Integer getAexist() {
        return aexist;
    }

    public void setAexist(Integer aexist) {
        this.aexist = aexist;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getDoId() {
        return doId;
    }

    public void setDoId(Integer doId) {
        this.doId = doId;
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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Admins{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", state=" + state +
                ", email='" + email + '\'' +
                ", lastPassworldResetDate=" + lastPassworldResetDate +
                ", aexist=" + aexist +
                ", loginTime=" + loginTime +
                ", doId=" + doId +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
