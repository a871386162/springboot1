package com.newer.springboot.Service;

import com.newer.springboot.domain.Departs;
import com.newer.springboot.domain.Drug;
import com.newer.springboot.mapper.DrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DrugService {
    @Autowired
    private DrugMapper drugMapper;
    public List<Drug>listAll(Double p1, Double p2){
        return drugMapper.listAll(p1,p2);
    }

    public int del(Integer drid){
        return drugMapper.del(drid);
    }

    public Drug queryByid(Integer drid){
        return  drugMapper.queryByid(drid);
    }

    public List<Departs>departsList(Integer drid){
        return drugMapper.findDrDe(drid);
    }

    public int addDrugDe(Integer drid,Integer deid){
        return drugMapper.addDrugDe(drid,deid);
    }
    public int addDrug(Drug drug){
        return drugMapper.add(drug);
    }

    public int updDrug(Drug drug){return  drugMapper.modifyDrug(drug);}

    public int removeDrDe(Integer drid){
        return drugMapper.removeDrDe(drid);
    }

    public int findID(){
        return drugMapper.findDrugId();
    }

    //改药状态
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int changeState(Integer drid, Integer drstate) {
        return drugMapper.changeState(drid, drstate);
    }
}

