package com.newer.springboot.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 安全用户类
 */
public class JwtUser implements UserDetails {

    private final Integer id;
    private final String username;
    private final String password;
    private final  String email;
    private final Integer state;
    private final Collection<? extends GrantedAuthority> authorities;
    private final Date lastPasswordResetDate;
    private final boolean enabled;


    public JwtUser(Integer id, String username, String password, String email, Collection<? extends GrantedAuthority> authorities, Date lastPasswordResetDate, boolean enable,Integer state) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.enabled = enable;
        this.state=state;
    }

    @JsonIgnore //将对象转出json格式时，这个属性的值未null
    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public Integer getState() {
        return state;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }


    @Override
    public String getUsername() {
        return username;
    }

    //用户账号是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //用户账号是否被锁
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //用户认证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
