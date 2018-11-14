package com.newer.springboot.mapper;

import com.newer.springboot.domain.DrugType;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugTypeMapper {
    @Select("select * from drugType")
    List<DrugType>listAll();
}
