package com.newer.springboot.security.domain;

import com.newer.springboot.domain.Admins;
import com.newer.springboot.domain.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

    /**
     * 通过admins对象转换成jwtUser的对象
     * @param admins
     * @return
     */
    public static JwtUser create(Admins admins){
        return new JwtUser(
                admins.getAid(),
                admins.getAname(),
                admins.getPwd(),
                admins.getEmail(),
                mapToGrantAuthorities(admins.getAuthorities()),
                admins.getLastPassworldResetDate(),
                admins.getAexist()==1?true:false,
                admins.getState()
        );
    }

    private static Collection<? extends GrantedAuthority> mapToGrantAuthorities(List<Authority> authorities) {
      return  authorities.stream().map(authority ->new SimpleGrantedAuthority(authority.getName().name())).collect(Collectors.toList());
    }
}
