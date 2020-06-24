package com.draduation.iservicesI;


import com.draduation.model.Student;

import java.util.List;

public interface ISerStu  {
    public String load(Student student);
    public List<String> getStringfiles(Student student);
}
