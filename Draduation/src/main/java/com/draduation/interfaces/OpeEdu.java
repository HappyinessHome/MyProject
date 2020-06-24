package com.draduation.interfaces;

import com.draduation.model.Education;
import org.apache.ibatis.annotations.Param;

public interface OpeEdu extends OpeFatch<Education> {
    public Education getByJobN(@Param("jobnumber")String jobnumber);
}
