package com.newer.springboot.mapper;

import com.newer.springboot.domain.Doctors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoctorsTests {
    @Autowired
    private DoctorsMapper doctorsMapper;

    @Test
    public void listAll(){
        List<Doctors>doctorsList = doctorsMapper.listAll("萧炎");
        for(Doctors doctors:doctorsList){
            System.out.println(doctors.getDoname());
        }
    }

    /*@Test
    public void insert(){
        Doctors doctors = new Doctors();
        doctors.setBcost(44.4);
        doctors.setTitle("牛逼的人");
        doctors.setDoname("吴英健");
        doctors.setDeid(3);
        doctors.setDoexist(1);
        doctors.setFriam(null);
        doctors.setFripm(null);//5
        doctors.setMonam(null);
        doctors.setMonpm(null);//1
        doctors.setThuam(1);
        doctors.setThupm(null);//4
        doctors.setSatam(1);//
        doctors.setSatpm(null);//7
        doctors.setSumpm(1);//
        doctors.setSunam(null);//6
        doctors.setTueam(1);
        doctors.setTuepm(null);//2
        doctors.setWedam(1);
        doctors.setWedpm(null);//3
        doctors.setInfo("手术厉害");
        doctors.setPcreg(100);
        doctors.setXcreg(100);
        doctors.setPhoto(null);
        int ret = doctorsMapper.addDcotors(doctors);
        System.out.println(ret);
    }

    @Test
    public void delete(){
        int ret = doctorsMapper.delDoctors(9);
        System.out.println(ret);
    }*/
}
