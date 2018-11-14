package com.newer.springboot.controller;

import com.newer.springboot.Service.DepartsService;
import com.newer.springboot.Service.DrugService;
import com.newer.springboot.Service.DrugTypeService;
import com.newer.springboot.domain.Departs;
import com.newer.springboot.domain.Drug;
import com.newer.springboot.domain.DrugType;
import com.newer.springboot.domain.Patients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("drug")
public class DrugController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private DrugTypeService drugTypeService;
    @Autowired
    private DepartsService departsService;

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public ResponseEntity<?>listAll(@RequestParam(value = "price1", required = false) Double price1,
                                    @RequestParam(value = "price2", required = false) Double price2){
        List<Drug>drugList = drugService.listAll(price1,price2);
        String dename = drugList.get(0).getDename();
        System.out.println(dename);
        if(drugList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugList,HttpStatus.OK);
    }

    @RequestMapping(value = "listDT",method = RequestMethod.GET)
    public ResponseEntity<?>listAllDT(){
        List<DrugType>drugTypeList = drugTypeService.listAll();
        if(drugTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(drugTypeList,HttpStatus.OK);
    }

    @RequestMapping(value = "listDP",method = RequestMethod.GET)
    public ResponseEntity<?>listAllDP(){
        List<Departs>departsList = departsService.listAll();
        if(departsList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(departsList,HttpStatus.OK);
    }

    @RequestMapping(value = "delete",method = RequestMethod.DELETE)
    public ResponseEntity<?>delDrug(@RequestParam(name = "drid")Integer drid){
        int ret = drugService.del(drid);
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "queryById",method = RequestMethod.GET)
    public ResponseEntity<?>queryById(@RequestParam(name = "drid")Integer drid){
        Drug drug = drugService.queryByid(drid);
        if(drug!=null){
            return new ResponseEntity<>(drug,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "drugdepart",method = RequestMethod.GET)
    public ResponseEntity<?> findDrDe(@RequestParam("drid") Integer drid) {
        List<Departs> departsList = drugService.departsList(drid);
        return new ResponseEntity<>(departsList, HttpStatus.OK);
    }

    @RequestMapping(value = "edit",method = RequestMethod.POST)
    public ResponseEntity<?>addDrug(@RequestParam(value = "drid") Integer drid,
                                    @RequestParam(value = "drstate") Integer drstate,
                                    @RequestParam(value = "drname") String drname,
                                    @RequestParam(value = "drsum") Integer drsum,
                                    @RequestParam(value = "drprice") Double drprice,
                                    @RequestParam(value = "dyid") Integer dyid,
                                    @RequestParam(value = "deid") int[] deid){
        Drug drug = new Drug(drid,dyid,drname,drsum,drprice);
        int ret = drugService.addDrug(drug);
        int drid1 = drugService.findID();
        System.out.println(deid.length);
        for(int i = 0;i<deid.length;i++){
            int ret1 = drugService.addDrugDe(drid1,deid[i]);
            if(i==deid.length){
                break;
            }
        }
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "edit",method = RequestMethod.PUT)
    public ResponseEntity<?>updDrug(@RequestParam(value = "drid") Integer drid,
                                    @RequestParam(value = "drstate") Integer drstate,
                                    @RequestParam(value = "drname") String drname,
                                    @RequestParam(value = "drsum") Integer drsum,
                                    @RequestParam(value = "drprice") Double drprice,
                                    @RequestParam(value = "dyid") Integer dyid,
                                    @RequestParam(value = "deid") int[] deid
                                    ){
        int ret=0;
        Drug drug = new Drug(drid,dyid,drname,drsum,drprice);
        ret = drugService.updDrug(drug);
        int ret2 = drugService.removeDrDe(drid);
            System.out.println(deid.length);
            for(int i = 0;i<deid.length;i++){
                int deid1 = deid[i];
                int ret1 = drugService.addDrugDe(drid,deid1);
                if(i==deid.length){
                    break;
                }
            }
        if(ret==1){
            return new ResponseEntity<>(ret,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * 改药品状态
     *
     * @param drid
     * @param drstate
     * @return
     */
    @RequestMapping(value = "drugschangestate")
    public ResponseEntity<?> changeState(@RequestParam(value = "drid") Integer drid, @RequestParam(value = "drstate") Integer drstate) {
        int result = drugService.changeState(drid, drstate);
        if (result == 1) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
