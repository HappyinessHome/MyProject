package com.draduation.interfaces;

import com.draduation.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpeStu extends OpeFatch<Student>{
    public Student getBySto(@Param("sto") String sto);
}
