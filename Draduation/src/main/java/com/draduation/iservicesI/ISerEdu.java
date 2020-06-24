package com.draduation.iservicesI;

import com.draduation.model.Education;
import org.apache.ibatis.annotations.Param;

public interface ISerEdu {
    public String load(Education edu);
    public Education getByJobN(@Param("jobnumber")String jobnumber);
}
