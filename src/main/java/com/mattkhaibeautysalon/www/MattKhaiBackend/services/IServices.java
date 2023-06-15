package com.mattkhaibeautysalon.www.MattKhaiBackend.services;

import java.util.List;

public interface IServices <T, X>{
    //Create a new record
    T create(T t);

    //Read all records
    List<T> findAll();

    //Update a record
    T update(X x, T t);

    //Delete a record by its ID
    boolean delete(X id);
}
