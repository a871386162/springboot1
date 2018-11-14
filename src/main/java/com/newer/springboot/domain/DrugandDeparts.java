package com.newer.springboot.domain;

public class DrugandDeparts {
    private Integer deid;
    private Integer drid;
    private Departs departs;



    public Departs getDeparts() {
        return departs;
    }

    public void setDeparts(Departs departs) {
        this.departs = departs;
    }

    public DrugandDeparts() {
    }

    public Integer getDeid() {
        return deid;
    }

    public void setDeid(Integer deid) {
        this.deid = deid;
    }

    public Integer getDrid() {
        return drid;
    }

    public void setDrid(Integer drid) {
        this.drid = drid;
    }

    @Override
    public String toString() {
        return "DrugandDeparts{" +
                "deid=" + deid +
                ", drid=" + drid +
                ", departs=" + departs +
                '}';
    }
}
