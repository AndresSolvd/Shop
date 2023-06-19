package com.solvd.sql.mybatis;

import com.solvd.sql.interfaces.IPersonDao;
import com.solvd.sql.model.Person;
import com.solvd.util.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PersonDao implements IPersonDao {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            personDao.insert(person);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            personDao.update(person);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            personDao.delete(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            persons = personDao.getAll();
        }
        return persons;
    }

    @Override
    public Person getById(int id) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            person = personDao.getById(id);
        }
        return person;
    }

    @Override
    public Person getByName(String name) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDao personDao = sqlSession.getMapper(IPersonDao.class);
            person = personDao.getByName(name);
        }
        return person;
    }
}
