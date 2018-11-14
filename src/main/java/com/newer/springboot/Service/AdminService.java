package com.newer.springboot.Service;

import com.newer.springboot.domain.Admins;
import com.newer.springboot.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Cacheable(cacheNames = "admins.query")
    public Admins login(String name,String pwd){
        return  adminMapper.login(name,pwd);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int updAmins(Admins admins){
        return  adminMapper.updAdmins(admins);
    }
}
