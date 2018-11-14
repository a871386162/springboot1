package com.newer.springboot.controller;

import com.newer.springboot.Service.BookableService;
import com.newer.springboot.Service.DepartsService;
import com.newer.springboot.domain.Admins;
import com.newer.springboot.domain.BookableCount;
import com.newer.springboot.domain.Departs;
import com.newer.springboot.security.JwtTokenUtil;
import com.newer.springboot.security.domain.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class bookableController {
    @Autowired
    private DepartsService departsService;
    @Autowired
    private BookableService bookableService;

    @RequestMapping(value = "bookdepart",method = RequestMethod.GET)
    public ResponseEntity<?>bookdepart(HttpServletRequest request){
        //1、查询所有门诊
        List<Departs> departsList = departsService.listAll();
        List<BookableCount>bookableCountList = new ArrayList<BookableCount>();
        for(Departs departs:departsList){
            int dayCount = bookableService.getToday(departs.getDeid());
            int yesCount = bookableService.getYesterday(departs.getDeid());
            int weekCount = bookableService.getWeek(departs.getDeid());
            int monCount = bookableService.getMonth(departs.getDeid());
            int quaCount = bookableService.getQuarter(departs.getDeid());
            BookableCount bookableCount = new BookableCount(departs.getDename(),dayCount,yesCount,weekCount,monCount,quaCount);
            bookableCountList.add(bookableCount);
        }
        if(bookableCountList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(bookableCountList,HttpStatus.OK);
    }

    /**
     * 封装本季度所有科室挂号人数
     * @return
     */
    @RequestMapping(value = "drawbook",method = RequestMethod.GET)
    public ResponseEntity<?>drawBook(HttpServletRequest request){
        List<Map<String,Object>>booklist = new ArrayList<Map<String,Object>>();
        List<Departs> departsList = departsService.listAll();
        for(Departs departs:departsList){
            Map<String,Object> map = new HashMap<>();
            int quaCount =  bookableService.getQuarter(departs.getDeid());
            map.put("name",departs.getDename());
            map.put("y",quaCount);
            map.put("drilldown",departs.getDename());
            booklist.add(map);
        }
        if(booklist.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(booklist,HttpStatus.OK);
    }
}
