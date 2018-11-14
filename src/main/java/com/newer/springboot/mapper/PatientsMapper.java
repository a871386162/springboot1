package com.newer.springboot.mapper;

import com.newer.springboot.domain.Patients;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientsMapper {
    List<Patients>listAll(@Param("pname")String pname);

    @Delete("delete from patients where pid = #{pid}")
    int deletePatients(@Param("pid")Integer pid);

    @Select("select * from patients where pid = #{pid}")
    Patients queryById(@Param("pid")Integer pid);

    @Insert("Insert into  patients (pname,gender,sex,phone,idcard,pwd,medcard,email)values(#{pname},#{gender},#{sex},#{phone},#{idCard},#{pwd},#{medCard},#{email})")
    int insertPatients(Patients patients);

    @Update("update  patients  set pname=#{pname},gender=#{gender},sex=#{sex},phone=#{phone},idcard=#{idCard},pwd=#{pwd},medcard=#{medCard},email=#{email} where pid=#{pid} ")
    int updatePatients(Patients patients);

    @Update("update patients set pwd=#{pwd} where pid=#{pid}")
    int changePwd(@Param("pid")Integer pid,@Param("pwd")String pwd);
}
