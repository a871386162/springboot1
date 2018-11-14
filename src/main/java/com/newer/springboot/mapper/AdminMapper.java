package com.newer.springboot.mapper;

import com.newer.springboot.domain.Admins;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {


    @Select("select * from Admins where aexist=1 and aname=#{aname} and pwd=#{pwd} ")
    public Admins login(@Param("aname")String aname, @Param("pwd")String pwd);

    @Update("update admins set pwd=#{pwd},lastpasswordresetdate=now() where aid=#{aid}")
    public int updAdmins(Admins admins);

    Admins findUserByUsername(@Param("aname")String aname);
}
