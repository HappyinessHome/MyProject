package com.draduation.model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String sto;
    private String name;
    private Integer age;
    private String sex;
    private String college;
    private String grade;
    private String major;
    private String password;
    private String filename;

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    private List<Match> matches=new ArrayList<>();
    public List<String> getFiles() {
        return files;
    }

    public void setFiles(List<String> files) {
        this.files = files;
    }

    private List<String> files;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }



    public Student() {
    }

    public Student(String sto, String name, Integer age, String sex, String college, String grade, String major) {
        this.sto = sto;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.college = college;
        this.grade = grade;
        this.major = major;
    }

    public String getSto() {
        return sto;
    }

    public void setSto(String sto) {
        this.sto = sto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sto='" + sto + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", college='" + college + '\'' +
                ", grade='" + grade + '\'' +
                ", major='" + major + '\'' +
                '}';
    }
}
