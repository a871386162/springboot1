package com.newer.springboot.mapper;

import com.newer.springboot.domain.Departs;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface DepartsMapper {
    @Select("select * from departs")
    public List<Departs> listAll();


}
