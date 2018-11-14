package com.newer.springboot.Service;

import com.newer.springboot.domain.Patients;
import com.newer.springboot.mapper.PatientsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientsService {
    @Autowired
    private PatientsMapper patientsMapper;

    public List<Patients>listAll(String pname){
        return patientsMapper.listAll(pname);
    }

    public int deletePatients(Integer pid){
        return  patientsMapper.deletePatients(pid);
    }

    public int insertPatients(Patients patients){
        return patientsMapper.insertPatients(patients);
    }

    public int updatePatients(Patients patients){
        return patientsMapper.updatePatients(patients);
    }

    public Patients queryById(Integer pid){
        return patientsMapper.queryById(pid);
    }

    public int changePwd(Integer pid,String pwd){
        return patientsMapper.changePwd(pid, pwd);
    }
}
