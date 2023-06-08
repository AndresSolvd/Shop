package com.solvd.sql.interfaces;

import java.util.List;

public interface IBaseDAO<T> {

    // CRUD Create
    void insert(T t);

    // CRUD Update
    void update(T t);

    // CRUD Delete
    void delete(int id);

    // Get All
    List<T> getAll();

    // CRUD Read
    T getById(int id);
}
