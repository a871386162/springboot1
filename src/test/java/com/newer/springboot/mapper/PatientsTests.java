package com.newer.springboot.mapper;

import com.newer.springboot.domain.Patients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PatientsTests {

    @Autowired
    private PatientsMapper patientsMapper;
    @Test
    public void ListAll(){
        List<com.newer.springboot.domain.Patients> patientsList = patientsMapper.listAll("");
        for(com.newer.springboot.domain.Patients patients:patientsList){
            System.out.println(patients);
        }
    }

    /*@Test
    public void delete(){
        int ret = patientsMapper.deletePatients(14);
        System.out.println(ret);
    }

    @Test
    public void  insert(){
        Patients patients = new Patients();
        patients.setPhone("121123125678");
        patients.setGender("F");
        patients.setPname("吴英健");
        patients.setSex("男");
        patients.setPwd("123466");
        patients.setIdCard("430121193402112230");
        patients.setMedCard("11111111");
        patients.setEmail("8712@qq.com");
        int ret = patientsMapper.insertPatients(patients);
        System.out.println(ret);
    }

    @Test
    public void queryById(){
        Patients patients = patientsMapper.queryById(15);
        System.out.println(patients);

    }

    @Test
    public void changePwd(){
        int ret = patientsMapper.changePwd(13,"777777");
        System.out.println(ret);
    }*/
}
