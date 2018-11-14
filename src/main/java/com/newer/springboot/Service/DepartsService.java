package com.newer.springboot.Service;


import com.newer.springboot.domain.Departs;
import com.newer.springboot.mapper.DepartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartsService {
    @Autowired
    private DepartsMapper departsMapper;
    public List<Departs>listAll(){
        return departsMapper.listAll();
    }
}
