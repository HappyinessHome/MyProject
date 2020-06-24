package com.draduation.controller;

import com.alibaba.fastjson.JSON;
import com.draduation.iservicesI.ISerFatch;
import com.draduation.iservicesI.ISerMat;
import com.draduation.iservicesI.ISerStu;
import com.draduation.model.Match;

import com.draduation.model.Student;
import com.draduation.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequestMapping("/match")
@Controller
public class MatchController {
    @Autowired
    private ISerFatch iSerFatch;
    @Autowired
    private ISerMat iSerMat;
    @Autowired
    private ISerStu serStu;

    @RequestMapping("/add")
    @ResponseBody
    public void add(@RequestBody Match match){
        iSerFatch.setOpeFatch("opeMat");
        iSerFatch.add(match);
    }
    @RequestMapping("/apply")
    @ResponseBody
    public void update(@RequestBody Match match){
       iSerMat.apply(match);
    }
    @RequestMapping("/getByTid")
    @ResponseBody
    public String getMatchsByTid(@RequestBody Match match){
        List<Match> stulist = iSerMat.getByTid(match.getTid());
        return JSON.toJSON(stulist).toString();
    }
    @RequestMapping("/getAll")
    @ResponseBody
    public String getAll(@RequestBody Match match){
        iSerFatch.setOpeFatch("opeMat");
        List<Object> matchlist = iSerFatch.getAll();
        List<Match> byTid = iSerMat.getByTid(match.getTid());
        System.out.println("===="+byTid.size());
        Utils.rematin(matchlist,byTid);

        return JSON.toJSON(matchlist).toString();
    }
    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody Match match){
        iSerFatch.setOpeFatch("opeMat");


       iSerFatch.delete(match);
    }
    @RequestMapping("/getMark")
    @ResponseBody
    public String getMark(){
        iSerFatch.setOpeFatch("opeStu");
        List<Object> allstu = iSerFatch.getAll();

        List<Student> marks = Utils.getMarks(allstu,iSerMat);


        return JSON.toJSON(marks).toString();
    }
}
