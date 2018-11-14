package com.newer.springboot.Service;

import com.newer.springboot.domain.Doctors;
import com.newer.springboot.mapper.DoctorsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorsService {
    @Autowired
    private DoctorsMapper doctorsMapper;

    public Doctors findById(Integer id){
        return doctorsMapper.findById(id);
    }
    public List<Doctors>listAll(String doname){
        return doctorsMapper.listAll(doname);
    }
    public int addDoctors(Doctors doctors){return doctorsMapper.addDcotors(doctors);}
    public int updDoctors(Doctors doctors){return doctorsMapper.updDcotors(doctors);}
    public int delDoctors(Integer doid){return doctorsMapper.delDoctors(doid);}
}
