package com.newer.springboot.domain;

public class BookableCount {
    private String dename;
    private int dayCount;
    private int yesCount;
    private int weekCount;
    private int monCount;
    private int quaCount;

    public BookableCount() {
    }

    public BookableCount(String dename, int dayCount, int yesCount, int weekCount, int monCount, int quaCount) {
        this.dename = dename;
        this.dayCount = dayCount;
        this.yesCount = yesCount;
        this.weekCount = weekCount;
        this.monCount = monCount;
        this.quaCount = quaCount;
    }

    public String getDename() {
        return dename;
    }

    public void setDename(String dename) {
        this.dename = dename;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public int getYesCount() {
        return yesCount;
    }

    public void setYesCount(int yesCount) {
        this.yesCount = yesCount;
    }

    public int getWeekCount() {
        return weekCount;
    }

    public void setWeekCount(int weekCount) {
        this.weekCount = weekCount;
    }

    public int getMonCount() {
        return monCount;
    }

    public void setMonCount(int monCount) {
        this.monCount = monCount;
    }

    public int getQuaCount() {
        return quaCount;
    }

    public void setQuaCount(int quaCount) {
        this.quaCount = quaCount;
    }

    @Override
    public String toString() {
        return "BookableCount{" +
                "dename='" + dename + '\'' +
                ", dayCount=" + dayCount +
                ", yesCount=" + yesCount +
                ", weekCount=" + weekCount +
                ", monCount=" + monCount +
                ", quaCount=" + quaCount +
                '}';
    }
}
