package com.newer.springboot.mapper;

import com.newer.springboot.Service.DrugTypeService;
import com.newer.springboot.domain.DrugType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugTypeTests {
    @Autowired
    private DrugTypeService drugTypeService;

    @Test
    public void listAll(){
        List<DrugType>drugTypeList = drugTypeService.listAll();
        for(DrugType drugType:drugTypeList){
            System.out.println(drugType);
        }
    }
}
