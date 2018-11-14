package com.newer.springboot;

import com.newer.springboot.Service.AdminService;
import com.newer.springboot.domain.Admins;
import com.newer.springboot.domain.Patients;
import com.newer.springboot.mapper.AdminMapper;
import com.newer.springboot.mapper.PatientsMapper;
import com.newer.springboot.util.MD5;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private PatientsMapper patientsMapper;

    @Autowired
    private AdminService adminService;

    @Test
    public void contextLoads() {
        String admin = MD5.getInstance().getMD5ofStr("admin");
        System.out.println(admin);
    }

    @Test
    public void login(){
        Admins admins = adminService.login("xiaoyan",MD5.getInstance().getMD5ofStr("admin"));
        System.out.println(admins);
    }

    @Test
    public void ListAll(){
        List<Patients>patientsList = patientsMapper.listAll("");
        for(Patients patients:patientsList){
            System.out.println(patients);
        }
    }

    @Test
    public void list2(){
        Admins admins = adminMapper.findUserByUsername("admin");
        System.out.println(admins);
    }

}
