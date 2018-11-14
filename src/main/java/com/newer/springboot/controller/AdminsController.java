package com.newer.springboot.controller;

import com.newer.springboot.Exception.HospitalException;
import com.newer.springboot.Service.AdminService;
import com.newer.springboot.Service.DoctorsService;
import com.newer.springboot.domain.Admins;
import com.newer.springboot.domain.CustomErrorType;
import com.newer.springboot.domain.Doctors;
import com.newer.springboot.security.JwtTokenUtil;
import com.newer.springboot.security.domain.JwtUser;
import com.newer.springboot.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api")
public class AdminsController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DoctorsService doctorsService;

    @RequestMapping(value = "users",method = RequestMethod.GET)
    public ResponseEntity<?>login(@RequestParam(name = "aname")String aname,
                                  @RequestParam(name = "pwd")String pwd,HttpSession session){
        //MD5.getInstance().getMD5ofStr(pwd)
        Admins admins = adminService.login(aname, MD5.getInstance().getMD5ofStr(pwd));
        if(admins==null){
            return new ResponseEntity<>(new CustomErrorType("密码或用户名错误"),HttpStatus.OK);
        }
        Doctors doctors = doctorsService.findById(admins.getDoId());
        if(doctors!=null){
            admins.setBy1(doctors.getTitle());
        }else {
            admins.setBy1("医生头衔");
        }
        session.setAttribute("admins", admins);
        return  new ResponseEntity<>(admins,HttpStatus.OK);
    }

    @RequestMapping(value = "userSession",method = RequestMethod.GET)
    public ResponseEntity<?>userSession(HttpSession httpSession){
        Admins admins = (Admins) httpSession.getAttribute("admins");
        return new ResponseEntity<>(admins,HttpStatus.OK);
    }

    @RequestMapping(value = "changePwd",method = RequestMethod.POST)
    public ResponseEntity<?>change_Pwd(@RequestParam(name = "pwd")String pwd,
                                       @RequestParam(name = "pwd1")String pwd1,
                                       @RequestParam(name = "pwd2")String pwd2,HttpServletRequest request
                                       ){
        String headerToken = request.getHeader("Authorization");
        JwtUser jwtUser = null;
        //注意大小写
        if(headerToken!=null && headerToken.startsWith("Bearer ")){
            String authToken =  headerToken.substring(7);
            //通过token获取用户名
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            jwtUser = (JwtUser)userDetailsService.loadUserByUsername(username);
        }
         pwd = new BCryptPasswordEncoder().encode(pwd);
        if(jwtUser.getPassword().equals(pwd)){
            return new ResponseEntity<>(new CustomErrorType("原密码不符合"),HttpStatus.OK);
        }else if(!pwd1.equals(pwd2)){
            return new ResponseEntity<>(new CustomErrorType("两次输入不一样"),HttpStatus.OK);
        }else{
            pwd1 = new BCryptPasswordEncoder().encode(pwd1);
            Admins admins = new Admins();
            admins.setPwd(pwd1);
            int ret = adminService.updAmins(admins);
            if(ret>0){
                return new ResponseEntity<>(ret,HttpStatus.OK);
            }
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
    }
    /*@RequestMapping(value = "logout",method = RequestMethod.GET)
    public ResponseEntity<?>logout(HttpServletRequest request){
        String headerToken = request.getHeader("Authorization");
        if(headerToken==null){
            return new ResponseEntity<>(new CustomErrorType("1"),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(new CustomErrorType("0"),HttpStatus.OK);
        }
    }

    @RequestMapping("/json")
    public String Global_Json(@RequestParam(name = "name")String name) throws  HospitalException {
        throw new HospitalException("你你你你你你你");
    }*/

    /**
     * 根据token获取用户信息
     * @return
     */
    @RequestMapping(value = "getUser",method = RequestMethod.GET)
    public ResponseEntity<JwtUser> getUser(HttpServletRequest request){
        //哈哈
        String headerToken = request.getHeader("Authorization");
        JwtUser jwtUser = null;
        //你妈妈11
        //注意大小写
        if(headerToken!=null && headerToken.startsWith("Bearer ")){
            String authToken =  headerToken.substring(7);
            //通过token获取用户名
            String username = jwtTokenUtil.getUsernameFromToken(authToken);
            jwtUser = (JwtUser)userDetailsService.loadUserByUsername(username);
        }
        return new ResponseEntity<>(jwtUser,HttpStatus.OK);

    }
}
