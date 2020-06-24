package com.draduation.services;

import com.draduation.interfaces.OpeFatch;
import com.draduation.iservicesI.ISerFatch;
import com.draduation.utils.Utils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
@Transactional
@Service
public class SerFatch implements ISerFatch{
    public SerFatch(){}

    public void  setOpeFatch(String beanName){
        this.opeFatch= Utils.getBeanMap().get(beanName);
    }
    private OpeFatch opeFatch;


    @Override
    public void add(Object o) {
        opeFatch.add(o);
    }

    @Override
    public void delete(Object o) {
        opeFatch.delete(o);
    }

    @Override
    public void update(Object o) {
        opeFatch.update(o);
    }

    @Override
    public Object getOne(Object o) {
        return opeFatch.getOne(o);
    }

    @Override
    public List getAll() {
        return opeFatch.getAll();
    }
}
