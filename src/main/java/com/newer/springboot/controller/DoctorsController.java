package com.newer.springboot.controller;

import com.newer.springboot.Service.DepartsService;
import com.newer.springboot.Service.DoctorsService;
import com.newer.springboot.domain.Departs;
import com.newer.springboot.domain.Doctors;
import com.newer.springboot.mapper.DepartsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
import java.util.List;

@RestController
@RequestMapping("doctors")
@PreAuthorize("hasRole('ADMIN')")
public class DoctorsController {
    @Autowired
    private DoctorsService doctorsService;

    @Autowired
    private DepartsService departsService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponseEntity<?>listAll(@RequestParam(name = "doname",required = false)String doname){
        List<Doctors>doctorsList = doctorsService.listAll(doname);
        if(doctorsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(doctorsList,HttpStatus.OK);
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<?>delDoctors(@RequestParam(name = "doid")Integer doid){
        int ret = doctorsService.delDoctors(doid);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResponseEntity<?>addDoctors(Doctors doctors){
        /*System.out.println(doctors.getDeparts().getDeid());
        Departs departs = new Departs();
        doctors.setDeparts(departs);*/
        int ret = doctorsService.addDoctors(doctors);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "edit",method = RequestMethod.PUT)
    public ResponseEntity<?>updDoctors(Doctors doctors){
        Integer deid = doctors.getDeparts().getDeid();
        doctors.setDeid(deid);
        int ret = doctorsService.updDoctors(doctors);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public ResponseEntity<?>queryById(@RequestParam(name = "doid")Integer doid){
        Doctors doctors = doctorsService.findById(doid);
        if(doctors!=null){
            return new ResponseEntity<>(doctors,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @RequestMapping(value = "listdeparts",method = RequestMethod.GET)
    public ResponseEntity<?>ListDeparts(){
        List<Departs> departsList =departsService.listAll();
        if(departsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departsList,HttpStatus.OK);
    }
}
