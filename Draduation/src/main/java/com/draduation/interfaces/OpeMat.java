package com.draduation.interfaces;
import com.draduation.model.Match;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OpeMat extends OpeFatch<Match>{
    public List<Match> getByTid(@Param("tid")String tid);
}
