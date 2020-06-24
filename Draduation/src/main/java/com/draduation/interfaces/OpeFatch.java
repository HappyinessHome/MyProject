package com.draduation.interfaces;

import java.util.List;

public interface OpeFatch<T> {
    public void add(T t);
    public void delete(T t);
    public void update(T t);
    public T getOne(T t);
    public List<T> getAll();

}
