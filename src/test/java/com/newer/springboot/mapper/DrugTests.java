package com.newer.springboot.mapper;

import com.newer.springboot.Service.DrugService;
import com.newer.springboot.domain.Drug;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrugTests {
    @Autowired
    private DrugService drugService;

    @Test
    public void listAll(){
        List<Drug>list = drugService.listAll(100.0,200.0);
        System.out.println(list.get(0).getDename());
    }
}
