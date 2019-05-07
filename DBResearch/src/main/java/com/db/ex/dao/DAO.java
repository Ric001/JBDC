package com.db.ex.dao;

import java.util.List;

public interface DAO<T, K> {
    
    void add(T t);
    
    T getById(K k);
    List<T> toList();
    void modify(T t);
    void delete(T t);
    
}