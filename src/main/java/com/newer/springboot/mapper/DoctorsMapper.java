package com.newer.springboot.mapper;

import com.newer.springboot.domain.Doctors;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorsMapper {

    @Select("Select * from doctors where doid=#{id}")
    Doctors findById(@Param("id")Integer id);

    List<Doctors>listAll(@Param("doname")String doname);

    @Insert("Insert into doctors(doname,title,photo,info,deid,monam,monpm,tueam,tuepm,wedam,wedpm,thuam,thupm,friam,fripm," +
            "satam,satpm,sunam,sumpm,pcreg,xcreg,doexist,bcost)values(#{doname},#{title},#{photo},#{info},#{departs.deid},#{monam}" +
            ",#{monpm},#{tueam},#{tuepm},#{wedam},#{wedpm},#{thuam},#{thupm},#{friam},#{fripm},#{satam},#{satpm}" +
            ",#{sunam},#{sumpm},#{pcreg},#{xcreg},#{doexist},#{bcost})")
    int addDcotors(Doctors doctors);

    @Update("Update doctors set doname=#{doname},title=#{title},photo=#{photo},info=#{info},deid=#{deid},monam=#{monam},monpm=#{monpm}" +
            ",tueam=#{tueam},tuepm=#{tuepm},wedam=#{wedam},wedpm=#{wedpm},thuam=#{thuam},tuepm=#{tuepm},wedam=#{wedam},wedpm=#{wedpm}" +
            ",thuam=#{thuam},thupm=#{thupm},friam=#{friam},fripm=#{fripm},satam=#{satam},satpm=#{satpm},sunam=#{sunam},sumpm=#{sumpm}" +
            ",pcreg=#{pcreg},xcreg=#{xcreg},doexist=#{doexist},bcost=#{bcost} where doid=#{doid}")
    int updDcotors(Doctors doctors);

    @Delete("delete from doctors where doid=#{doid} ")
    int delDoctors(Integer doid);
}
