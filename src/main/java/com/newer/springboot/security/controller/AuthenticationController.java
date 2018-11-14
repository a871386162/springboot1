package com.newer.springboot.security.controller;

import com.newer.springboot.security.JwtTokenUtil;
import com.newer.springboot.security.domain.JwtAuenticationRequest;
import com.newer.springboot.security.domain.JwtAuthenticationResponse;
import com.newer.springboot.security.domain.JwtUser;
import com.newer.springboot.security.exception.AuthenticationException;
import com.newer.springboot.security.service.JwtUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class AuthenticationController {

    //还不能注入AuthenticationManager类
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.header}")
    private String requestHeader;

    // /auth 登陆
    @RequestMapping(value = "${jwt.route.authentication.path}",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtAuenticationRequest jwtAuenticationRequest) throws AuthenticationException {
           //认证
        authenticate(jwtAuenticationRequest.getUsername(),jwtAuenticationRequest.getPassword());

        // Reload password post-security so we can generate the token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtAuenticationRequest.getUsername());
        //用户用户信息生成token
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}",method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request){
        //获取token的值
        String requestHeader = request.getHeader(this.requestHeader);
        //去掉Bearer 得到真正的token
        String authToken = requestHeader.substring(7);
        //根据token获取当前用户的用户名
        String username = jwtTokenUtil.getUsernameFromToken(authToken);
        //根据用户名查询用户的信息
        JwtUser jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username);
        //判断当前用户的token是否可以被更新
        if(jwtTokenUtil.canTokenBeRefreshed(authToken,jwtUser.getLastPasswordResetDate())){
            //根据原有的token生成新的token值
            String refreshToken=jwtTokenUtil.refreshToken(authToken);
            //返回token值
            return new ResponseEntity<>(new JwtAuthenticationResponse(refreshToken),HttpStatus.OK);
        }else{
            //错误的请求
            return ResponseEntity.badRequest().body(null);
        }

    }

    /**
     * 异常处理:捕获当前这个controller中的异常
     * @param e
     * @return
     */
    @ExceptionHandler({AuthenticationException.class})
    public ResponseEntity<String> handleException(AuthenticationException e){
        return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
    }

    /**
     * 当前登陆人的用户名和密码认证
     * @param username
     * @param password
     */
    private void authenticate(String username, String password) {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            //认证当前登陆用户 校验用户名和密码，
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new AuthenticationException("User is disabled!", e);
        } catch (BadCredentialsException e) {
            throw new AuthenticationException("Bad credentials!", e);
        }
    }


}
