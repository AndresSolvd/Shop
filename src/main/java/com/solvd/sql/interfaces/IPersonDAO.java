package com.solvd.sql.interfaces;

import com.solvd.sql.model.Person;

import java.util.List;

public interface IPersonDAO extends IDao<Person>{
    List<Person> getPersonFirstName(String firstName);
}
