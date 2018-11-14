package com.newer.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
    @RequestMapping("hello")
    public String test(){
        return "index";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestParam(name = "username")String username,
                        @RequestParam(name = "userpwd")String userpwd){
        if("admin".equals(username)&&"admin".equals(userpwd)){
            return "success";
        }else{
            return "error";
        }
    }
}
