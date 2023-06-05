package com.solvd.sql.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface IDao<T> {

    // CRUD Create
    void insert(T t) throws SQLException;

    // CRUD Read
    T get(int id) throws SQLException;

    // CRUD Update
    void update(T t) throws SQLException;

    // CRUD Delete
    void delete(T t);

    // Get All
    List<T> getAll() throws SQLException;
}
