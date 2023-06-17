package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IBaseDAO;
import com.solvd.sql.model.Person;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PersonDao implements IBaseDAO<Person> {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Person> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.insert(person);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Person> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.update(person);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Person> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            baseDAO.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Person> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            persons = baseDAO.getAll();
        }
        return persons;
    }

    @Override
    public Person getById(int id) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IBaseDAO<Person> baseDAO = sqlSession.getMapper(IBaseDAO.class);
            person = baseDAO.getById(id);
        }
        return person;
    }
}
