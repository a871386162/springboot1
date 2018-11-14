package com.newer.springboot.Service;

import com.newer.springboot.domain.DrugType;
import com.newer.springboot.mapper.DrugTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugTypeService {
    @Autowired
    private DrugTypeMapper drugTypeMapper;
    public List<DrugType>listAll(){
        return drugTypeMapper.listAll();
    }
}
