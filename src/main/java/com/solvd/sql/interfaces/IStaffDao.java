package com.solvd.sql.interfaces;

import com.solvd.sql.model.Staff;

public interface IStaffDao extends IBaseDAO<Staff> {
    Staff getByName(String name);
}
