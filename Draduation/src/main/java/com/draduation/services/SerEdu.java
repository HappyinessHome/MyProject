package com.draduation.services;

import com.draduation.interfaces.OpeEdu;
import com.draduation.iservicesI.ISerEdu;
import com.draduation.model.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SerEdu implements ISerEdu {
    @Autowired
    private OpeEdu opeEdu;
    @Override
    public String load(Education edu) {
        Education one = opeEdu.getOne(edu);
        System.out.println(edu.toString());
        if(one==null){
            Education byJobN = opeEdu.getByJobN(edu.getJobnumber());
            if(byJobN==null)
                return "无此工号";
            return "密码错误";
        }

        return null;
    }

    @Override
    public Education getByJobN(String jobnumber) {
        return opeEdu.getByJobN(jobnumber);
    }
}
