package com.newer.springboot.mapper;

import com.newer.springboot.domain.DrugandDeparts;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface DrugandDepartsMapper {
    @Select("select * from druganddeparts where drid=#{drid}")
    DrugandDeparts queryById(@Param("drid")Integer drid);


}
