package com.draduation.services;

import com.draduation.interfaces.OpeFatch;
import com.draduation.interfaces.OpeStu;
import com.draduation.iservicesI.ISerFatch;
import com.draduation.iservicesI.ISerStu;
import com.draduation.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class SerStu  implements ISerStu {

    @Autowired
    private OpeStu opeStu;
    @Override
    public String load(Student student) {
        StringBuffer note=new StringBuffer();
        Student one = opeStu.getOne(student);
        if(one==null){
           if(opeStu.getBySto(student.getSto())!=null){
               return note.append("密码错误").toString();
           }else{
               return note.append("无此学号").toString();
           }
        }
        return null;
    }

    @Override
    public List<String> getStringfiles(Student student) {
        List<String> orgfiles = Arrays.asList(opeStu.getOne(student).getFilename().split(","));
//        for(int i=0;i<orgfiles.size();i++){
//           String orgname=orgfiles.get(i);
//           String toname=orgname.substring(0,orgname.length()-32);
//           orgfiles.set(i,toname);
//        }
        return orgfiles;
    }
}
