package com.draduation.utils;

import com.draduation.interfaces.OpeFatch;
import com.draduation.interfaces.OpeStu;
import com.draduation.iservicesI.ISerMat;
import com.draduation.model.Match;
import com.draduation.model.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Utils {



   public static Map<String, OpeFatch> getBeanMap(){
       ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
       Map<String, OpeFatch> beanmap = context.getBeansOfType(OpeFatch.class);
       return beanmap;
   }
   public static void rematin(List<Object> list,List<Match> matchList){

       for(int i=0;i<list.size();i++){

          Match match= (Match) list.get(i);
           System.out.println("---"+match.getName());
           for(int j=0;j<matchList.size();j++){
               String name=matchList.get(j).getName();

               if(name.equals(match.getName())){

                   list.remove(i);
                   i--;
                   break;
               }
           }
           SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
           String formatTime = format.format(match.getTime());
           match.setToTime(formatTime);
       }

   }
    public  static List<Student> getfiles(List<Object> list){
       List<Student> filelist=new ArrayList<>();
        for (Object o : list) {
            Student stu= (Student) o;
            if(stu.getFilename()!=null&&stu.getFilename().trim()!=""){
                stu.setFiles(Arrays.asList(stu.getFilename().split(",")));
                filelist.add(stu);
            }


        }
        return filelist;
    }

    public  static List<Student> getMarks(List<Object> list, ISerMat iSerMat){
        List<Student> marklist=new ArrayList<>();

        List<Match> uplist=new ArrayList<>();
        for (Object o : list) {
           Student student= (Student) o;
            List<Match> byTid = iSerMat.getByTid(student.getSto());
            if(byTid.size()!=0){



                for (Match match : byTid) {
                    marklist.add(student);
                    if(match.getMark()==2||match.getMark()==3){
                        uplist.add(match);
                        match.setMark(3);
                        student.getMatches().add(match);
                    }
                }
            }

        }
       iSerMat.updateList(uplist);
        return marklist;
    }

}
