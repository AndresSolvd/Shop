package com.solvd.sql.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IBaseDAO<T> {

    // CRUD Create
    void insert(T t) throws SQLException;

    // CRUD Update
    void update(T t) throws SQLException;

    // CRUD Delete
    void delete(int id) throws SQLException;

    // Get All
    List<T> getAll() throws SQLException;

    // CRUD Read
    T getById(int id) throws SQLException;
}
