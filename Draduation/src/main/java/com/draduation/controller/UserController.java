package com.draduation.controller;

import com.alibaba.fastjson.JSON;
import com.draduation.iservicesI.ISerFatch;
import com.draduation.iservicesI.ISerStu;
import com.draduation.model.Student;
import com.draduation.utils.Utils;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.annotations.Param;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private ISerFatch iSerFatch;
    @Autowired
    private ISerStu iSerStu;
    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "test";
    }
    @RequestMapping("/register")
    public void register(Student student){
        iSerFatch.setOpeFatch("opeStu");
        iSerFatch.add(student);
    }
    @RequestMapping("update")
    @ResponseBody
    public void update(@RequestBody Student student){
        System.out.println("==========="+student.toString());
        iSerFatch.setOpeFatch("opeStu");
        iSerFatch.update(student);
    }
    @RequestMapping("/load")
    @ResponseBody
    public String load(HttpServletRequest request,@RequestBody Student student){
        iSerFatch.setOpeFatch("opeStu");
        JSONObject jsonObject=new JSONObject();

        String loadnote = iSerStu.load(student);
        jsonObject.put("note",loadnote);
        if(loadnote!=null){
            request.getSession().setAttribute("sto",student.getSto());
            return jsonObject.toString();
        }

        return null;
    }
    @RequestMapping("/getOne")
    @ResponseBody
    public String getOne(@RequestBody Student student){

        iSerFatch.setOpeFatch("opeStu");
        Student tostudent= (Student) iSerFatch.getOne(student);

        return JSON.toJSONString(tostudent).toString();
    }
    @RequestMapping("/upload")
    public String upload( HttpServletRequest request,@RequestParam("file") MultipartFile file){
        String originalFilename = file.getOriginalFilename();
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        String toname=uuid+"-"+originalFilename;
        iSerFatch.setOpeFatch("opeStu");


        Student student=new Student();
        student.setSto(request.getParameter("sto"));
        Student one = (Student) iSerFatch.getOne(student);
        String savename=one.getFilename()+toname;
        student.setFilename(savename+",");
        student.setSto(request.getParameter("sto"));
        StringBuilder path=new StringBuilder();
        path.append(File.separator).append("files").append(File.separator).append(toname);
        String contextPath = request.getSession().getServletContext().getRealPath(path.toString());
        File tofile=new File(contextPath);

        try {
           FileUtils.copyInputStreamToFile(file.getInputStream(),tofile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        iSerFatch.update(student);
        return "redirect:../student.jsp";
    }
    @RequestMapping("/stringfiles")
    @ResponseBody
    public String getStringfiles(Student student){
        iSerFatch.setOpeFatch("opeStu");
        List<Student> getfiles = Utils.getfiles(iSerFatch.getAll());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("files",getfiles);
        return jsonObject.toString();
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request, HttpServletResponse response, @Param("filename")String filename){
        StringBuilder path=new StringBuilder();
        path.append(File.separator).append("files").append(File.separator).append(filename);
        String realPath = request.getSession().getServletContext().getRealPath(path.toString());
        File file=new File(realPath);
        System.out.println("=============================="+filename);
        byte[] body=null;
        ResponseEntity<byte[]> entity=null;
        try {
            FileInputStream inputStream=new FileInputStream(file);
            body=new byte[inputStream.available()];
            int read = inputStream.read(body);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attchement;filename=" + file.getName());
            headers.add("Content-Type", "application/octet-stream; charset=utf-8");
            HttpStatus statusCode = HttpStatus.OK;

            entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }
}
