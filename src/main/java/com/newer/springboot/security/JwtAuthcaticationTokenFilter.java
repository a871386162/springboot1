package com.newer.springboot.security;

import com.newer.springboot.security.service.JwtUserDetailsServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class JwtAuthcaticationTokenFilter extends OncePerRequestFilter {

    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String tokenHeader;
    private JwtTokenUtil jwtTokenUtil;
    private UserDetailsService userDetailsService;


    public JwtAuthcaticationTokenFilter(String tokenHeader, JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService) {
        this.tokenHeader = tokenHeader;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException,ServletException{

        logger.info(" process authentication for  " + request.getRequestURL());
        //获取到当前请求的头部信息 令牌
        String requestHeader =  request.getHeader(tokenHeader);

        String authToken=null;
        String username = null;
        if(requestHeader!=null && requestHeader.startsWith("Bearer ")){
            //获取token的值 Bearer XXX
            authToken = requestHeader.substring(7);
            try{
                //根据token获取当前用户的用户名
                username = jwtTokenUtil.getUsernameFromToken(authToken);
            }catch (IllegalArgumentException e){
                logger.info("and occured error and during get username from token",e);
            }catch (ExpiredJwtException e){
                logger.warn("the token is expired and not vaild anymore");
            }
        }else{
            logger.warn("can't find Token start with Bearer ,will ignore the header");
        }

        logger.info("checking authencation for " + username);
        if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null){
           //在这里可以从数据库中查看User的信息，也可以通过token来获取，以下为数据库查询
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


           //将获得的用户信息封装到authentication对象中 认证
           UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());

           authentication.setDetails(userDetails);
           //设置认证后的信息
           SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        filterChain.doFilter(request,response);
    }
}
