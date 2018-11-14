package com.newer.springboot.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface BookableMapper {


    @Select("select count(snum)from bookable b,doctors do,departs de,registration r where " +
            "r.bid = b.bid and do.doid = b.doid and de.deid = do.deid and to_days(bdate)=to_days(now()) and de.deid=#{deid}")
    int getToday(@Param("deid") Integer deid);

    @Select("select count(snum)from bookable b,doctors do,departs de,registration r where " +
            "r.bid = b.bid and do.doid = b.doid and de.deid = do.deid and to_days(now())-to_days(bdate=1) and de.deid=#{deid}")
    int getYesterday(@Param("deid") Integer deid);

    @Select("select count(snum)from bookable b,doctors do,departs de,registration r where " +
            "r.bid = b.bid and do.doid = b.doid and de.deid = do.deid and YEARWEEK(date_format(bdate,'%Y-%m-%d')) = YEARWEEK(now()) and de.deid=#{deid}")
    int getWeek(@Param("deid") Integer deid);

    @Select("select count(snum)from bookable b,doctors do,departs de,registration r where r.bid = b.bid and do.doid = b.doid and de.deid = do.deid and date_format(bdate,'%Y%m') = date_format(curdate(),'%Y%m') and de.deid=#{deid}")
    int getMonth(@Param("deid") Integer deid);

    @Select("select count(snum)from bookable b,doctors do,departs de,registration r where " +
            "r.bid = b.bid and do.doid = b.doid and de.deid = do.deid and QUARTER(bdate)=QUARTER(now()) and de.deid=#{deid}")
    int getQuarter(@Param("deid") Integer deid);
}
