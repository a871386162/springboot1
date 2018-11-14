package com.newer.springboot.domain;

import java.io.Serializable;

public class Departs implements Serializable {

    private static final long serialVersionUID = -5518499170956683315L;

    private Integer deid;

    private String dename;

    private String intro;

    private Integer deexist;

    private String by1;

    private Integer by2;

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getDeexist() {
        return deexist;
    }

    public void setDeexist(Integer deexist) {
        this.deexist = deexist;
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
        return "Departs{" +
                "deid=" + deid +
                ", dename='" + dename + '\'' +
                ", intro='" + intro + '\'' +
                ", deexist=" + deexist +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
