package com.draduation.services;

import com.draduation.interfaces.OpeMat;
import com.draduation.iservicesI.ISerMat;
import com.draduation.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
@Transactional
public class SerMat implements ISerMat {
    @Autowired
    private OpeMat opeMat;

    @Override
    public List<Match> getByTid(String tid) {
        List<Match> stulist = opeMat.getByTid(tid);

        for(int i=0;i<stulist.size();i++){
            Match match = stulist.get(i);
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
            String formatTime = format.format(match.getTime());
            match.setToTime(formatTime);
        }
        return stulist;
    }

    @Override
    public void apply(Match match) {
        Match matchid=new Match();
        matchid.setId(match.getId());

        if(match.getTid()!=null){
            Match one = opeMat.getOne(matchid);
            one.setTid(match.getTid());
            one.setMark(match.getMark());
            opeMat.add(one);
        }else {

            matchid.setMark(match.getMark());

            opeMat.update(matchid);
        }

    }

    @Override
    public void updateList(List<Match> marks) {
        for (Match mark : marks) {
            mark.setMark(3);
            opeMat.update(mark);
        }
    }


}
