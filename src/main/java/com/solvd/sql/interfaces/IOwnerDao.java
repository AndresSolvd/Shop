package com.solvd.sql.interfaces;

import com.solvd.sql.model.Owner;

public interface IOwnerDao extends IBaseDAO<Owner> {

    Owner getOwnerByName(String name);
}
