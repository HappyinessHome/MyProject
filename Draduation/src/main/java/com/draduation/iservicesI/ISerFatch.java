package com.draduation.iservicesI;

import com.draduation.interfaces.OpeFatch;

import java.util.List;

public interface ISerFatch  {
    public void add(Object t);
    public void delete(Object t);
    public void update(Object t);
    public Object getOne(Object t);
    public List<Object> getAll();
    public void  setOpeFatch(String beanName);
}
