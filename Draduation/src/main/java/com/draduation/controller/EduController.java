package com.draduation.controller;

import com.alibaba.fastjson.JSON;
import com.draduation.iservicesI.ISerEdu;
import com.draduation.iservicesI.ISerFatch;
import com.draduation.model.Education;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/edu")
@Controller
public class EduController {
    @Autowired
    private ISerFatch iSerFatch;
    @Autowired
    private ISerEdu iSerEdu;
    @RequestMapping("/register")
    public void register(@RequestBody Education education){
        iSerFatch.setOpeFatch("opeEdu");
        iSerFatch.add(education);
    }
    @RequestMapping("/get")
    @ResponseBody
    public String test(){
        return "hello";
    }



    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(@RequestBody Education education){
        iSerFatch.setOpeFatch("opeEdu");
        System.out.println(education.getJobnumber()+"==============");
        return JSON.toJSON(iSerEdu.getByJobN(education.getJobnumber())).toString();
    }

    @RequestMapping("/update")
    @ResponseBody
    public void update(@RequestBody Education education){
        iSerFatch.setOpeFatch("opeEdu");
        iSerFatch.update(education);
    }
    @RequestMapping("/load")
    @ResponseBody
    public String load(HttpServletRequest request, @RequestBody Education education){
        iSerFatch.setOpeFatch("opeEdu");
        ModelAndView modelAndView=new ModelAndView();
        String loadnote = iSerEdu.load(education);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("note",loadnote);

        if(loadnote!=null){
            request.getSession().setAttribute("jobnumber",education.getJobnumber());
            return jsonObject.toString();
        }

        return null;
    }


}
