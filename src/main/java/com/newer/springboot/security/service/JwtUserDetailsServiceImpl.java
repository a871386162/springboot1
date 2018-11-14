package com.newer.springboot.security.service;

import com.newer.springboot.domain.Admins;
import com.newer.springboot.mapper.AdminMapper;
import com.newer.springboot.security.domain.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminMapper adminsMapper;
    /**
     * 根据用户名查询用户信息
     * Admins ----> 一对多  一个用户对应多个角色
     * adminsMapper
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //用户名必须时唯一的
       Admins admins =  adminsMapper.findUserByUsername(username);
       if(admins==null){
           throw  new UsernameNotFoundException(" can not find username with " + username);
       }
        return JwtUserFactory.create(admins);
    }
}
