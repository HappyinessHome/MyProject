package com.draduation.iservicesI;

import com.draduation.model.Match;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISerMat {
    public List<Match> getByTid(String tid);
    public void apply(Match match);

    void updateList(List<Match> marks);
}
