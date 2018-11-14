package com.newer.springboot.mapper;

import com.newer.springboot.domain.Departs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartsTests {
    @Autowired
    private DepartsMapper departsMapper;

    @Test
    public void listAll(){
        List<Departs>list = departsMapper.listAll();
        for(Departs departs:list){
            System.out.println(departs);
        }
    }
}
