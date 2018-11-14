package com.newer.springboot.domain;

import java.io.Serializable;

public class Doctors implements Serializable {
    private static final long serialVersionUID = -5647190597767663083L;
    private Integer doid;
    private String doname;
    private String title;
    private String photo;
    private String info;
    private Integer deid;//科室ID
    private Departs departs;
    private Integer monam;
    private Integer monpm;
    private Integer tueam;
    private Integer tuepm;
    private Integer wedam;
    private Integer wedpm;
    private Integer thuam;
    private Integer thupm;
    private Integer fripm;
    private Integer friam;
    private Integer satpm;
    private Integer satam;
    private Integer sunam;
    private Integer sumpm;
    private int pcreg;
    private int xcreg;
    private int doexist;
    private double bcost;
    private String by1;
    private Integer by2;

    public Doctors() {

    }
    public Integer getDoid() {
        return doid;
    }

    public void setDoid(Integer doid) {
        this.doid = doid;
    }

    public String getDoname() {
        return doname;
    }

    public void setDoname(String doname) {
        this.doname = doname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public Departs getDeparts() {
        return departs;
    }

    public void setDeparts(Departs departs) {
        this.departs = departs;
    }

    public Integer getMonam() {
        return monam;
    }

    public void setMonam(Integer monam) {
        this.monam = monam;
    }

    public Integer getMonpm() {
        return monpm;
    }

    public void setMonpm(Integer monpm) {
        this.monpm = monpm;
    }

    public Integer getTueam() {
        return tueam;
    }

    public void setTueam(Integer tueam) {
        this.tueam = tueam;
    }

    public Integer getTuepm() {
        return tuepm;
    }

    public void setTuepm(Integer tuepm) {
        this.tuepm = tuepm;
    }

    public Integer getWedam() {
        return wedam;
    }

    public void setWedam(Integer wedam) {
        this.wedam = wedam;
    }

    public Integer getWedpm() {
        return wedpm;
    }

    public void setWedpm(Integer wedpm) {
        this.wedpm = wedpm;
    }

    public Integer getThuam() {
        return thuam;
    }

    public void setThuam(Integer thuam) {
        this.thuam = thuam;
    }

    public Integer getThupm() {
        return thupm;
    }

    public void setThupm(Integer thupm) {
        this.thupm = thupm;
    }

    public Integer getFripm() {
        return fripm;
    }

    public void setFripm(Integer fripm) {
        this.fripm = fripm;
    }

    public Integer getFriam() {
        return friam;
    }

    public void setFriam(Integer friam) {
        this.friam = friam;
    }

    public Integer getSatpm() {
        return satpm;
    }

    public void setSatpm(Integer satpm) {
        this.satpm = satpm;
    }

    public Integer getSatam() {
        return satam;
    }

    public void setSatam(Integer satam) {
        this.satam = satam;
    }

    public Integer getSunam() {
        return sunam;
    }

    public void setSunam(Integer sunam) {
        this.sunam = sunam;
    }

    public Integer getSumpm() {
        return sumpm;
    }

    public void setSumpm(Integer sumpm) {
        this.sumpm = sumpm;
    }

    public int getPcreg() {
        return pcreg;
    }

    public void setPcreg(int pcreg) {
        this.pcreg = pcreg;
    }

    public int getXcreg() {
        return xcreg;
    }

    public void setXcreg(int xcreg) {
        this.xcreg = xcreg;
    }

    public int getDoexist() {
        return doexist;
    }

    public void setDoexist(int doexist) {
        this.doexist = doexist;
    }

    public double getBcost() {
        return bcost;
    }

    public void setBcost(double bcost) {
        this.bcost = bcost;
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
        return "Doctors{" +
                "doid=" + doid +
                ", doname='" + doname + '\'' +
                ", title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", info='" + info + '\'' +
                ", deid='" + deid + '\'' +
                ", departs=" + departs +
                ", monam=" + monam +
                ", monpm=" + monpm +
                ", tueam=" + tueam +
                ", tuepm=" + tuepm +
                ", wedam=" + wedam +
                ", wedpm=" + wedpm +
                ", thuam=" + thuam +
                ", thupm=" + thupm +
                ", fripm=" + fripm +
                ", friam=" + friam +
                ", satpm=" + satpm +
                ", satam=" + satam +
                ", sunam=" + sunam +
                ", sumpm=" + sumpm +
                ", pcreg=" + pcreg +
                ", xcreg=" + xcreg +
                ", doexist=" + doexist +
                ", bcost=" + bcost +
                ", by1='" + by1 + '\'' +
                ", by2=" + by2 +
                '}';
    }
}
