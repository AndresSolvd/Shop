package com.solvd;

import com.solvd.sql.mybatis.CategoryDao;

public class MyBatisMain {
    public static void main(String[] args) {
        System.out.println(new CategoryDao().getById(1));
    }
}
