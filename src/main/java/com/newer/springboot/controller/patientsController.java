package com.newer.springboot.controller;

import com.newer.springboot.Service.PatientsService;
import com.newer.springboot.domain.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("patients")
@PreAuthorize("hasRole('ADMIN')")
public class patientsController {
    @Autowired
    private PatientsService patientsService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponseEntity<?>listAll(@RequestParam(name = "pname",required = false)String pname){
        List<Patients>patientsList = patientsService.listAll(pname);
        if(patientsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(patientsList,HttpStatus.OK);
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<?>deletePatients(@RequestParam(name = "pid",required = false)Integer pid){
        int ret = patientsService.deletePatients(pid);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResponseEntity<?>addPatients( Patients patients){
        int ret = patientsService.insertPatients(patients);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "edit",method = RequestMethod.PUT)
    public ResponseEntity<?>updPatients(Patients patients){
        int ret = patientsService.updatePatients(patients);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "query",method = RequestMethod.GET)
    public ResponseEntity<?>queryById(@RequestParam(name = "pid")Integer pid){
        Patients patients = patientsService.queryById(pid);
        if(patients!=null){
            return new ResponseEntity<>(patients,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "changePwd",method = RequestMethod.PUT)
    public ResponseEntity<?>change_pwd(@RequestParam(name = "pid")Integer pid,@RequestParam(name = "pwd")String pwd){
        int ret = patientsService.changePwd(pid, pwd);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
