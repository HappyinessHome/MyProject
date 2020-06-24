package com.draduation.model;

import java.util.Date;

public class Match {
    private Integer id;
    private String type;
    private Date time;
    private String name;
    private Integer mark;
    private String tid;

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    private String toTime;
    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id='" + id + '\'' +
                "type='" + type + '\'' +
                ", time=" + time +
                ", name='" + name + '\'' +
                ", mark=" + mark +

                '}';
    }
}
