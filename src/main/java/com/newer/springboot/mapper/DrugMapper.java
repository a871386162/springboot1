package com.newer.springboot.mapper;

import com.newer.springboot.domain.Departs;
import com.newer.springboot.domain.Drug;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DrugMapper {
    List<Drug>listAll(@Param("price1") Double price1, @Param("price2") Double price2);

    @Delete("delete from drug where drid=#{drid}")
    int del(@Param("drid")Integer drid);

    @Select("select * from drug where drid=#{drid}")
    Drug queryByid(@Param("drid")Integer drid);

    @Insert("insert into drug(drid,dyid,drname,drsum,drprice,drstate) values (#{drid},#{dyid},#{drname},#{drsum},#{drprice},1 )")
    int add(Drug drug);

    //查药品主键
    @Select("select max(drid) from drug")
    int findDrugId();

    @Update("update drug set dyid=#{dyid},drname=#{drname},drsum=#{drsum},drprice=#{drprice},drstate=1 where drid = #{drid}")
    int modifyDrug(Drug drug);

    //新增药品科室关系
    @Insert("insert into druganddeparts(drid,deid) values(#{drid},#{deid})")
    int addDrugDe(@Param("drid") Integer drid, @Param("deid") Integer deid);

    //删除药品科室关系
    @Delete("delete from druganddeparts where drid = #{drid}")
    int removeDrDe(@Param("drid") Integer drid);

    //查药品科室关系
    @Select("select t.deid,t.dename from departs t left join druganddeparts d on t.deid = d.deid where d.drid = #{drid}")
    List<Departs> findDrDe(@Param("drid") Integer drid);

    //改状态
    @Update("update drug set drstate = #{drstate} where drid = #{drid}")
    int changeState(@Param("drid") Integer drid, @Param("drstate") Integer drstate);


}
