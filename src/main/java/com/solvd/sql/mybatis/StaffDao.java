package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IStaffDao;
import com.solvd.sql.model.Staff;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class StaffDao implements IStaffDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Staff staff) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staffDao.insert(staff);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Staff staff) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staffDao.update(staff);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staffDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Staff> getAll() {
        List<Staff> staffs;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staffs = staffDao.getAll();
        }
        return staffs;
    }

    @Override
    public Staff getById(int id) {
        Staff staff;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staff = staffDao.getById(id);
        }
        return staff;
    }

    @Override
    public Staff getStaffByName(String name) {
        Staff staff;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IStaffDao staffDao = sqlSession.getMapper(IStaffDao.class);
            staff = staffDao.getStaffByName(name);
        }
        return staff;
    }
}
