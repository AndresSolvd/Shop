package com.solvd.sql.jdbc;

import com.solvd.sql.interfaces.IPersonDao;
import com.solvd.sql.model.Person;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDao implements IPersonDao {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void insert(Person person) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO person (person_name, last_name, phone, address) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getPersonName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getAddress());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (con != null) {
                connectionPool.releaseConnection(con);
            }
        }
    }

    @Override
    public void update(Person person) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE person SET person_name = ?, last_name = ?, phone = ?, address = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getPersonName());
            ps.setString(2, person.getLastName());
            ps.setString(3, person.getPhone());
            ps.setString(4, person.getAddress());
            ps.setInt(5, person.getId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException();
        } finally {
            connectionPool.releaseConnection(con);
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM person WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
    }

    @Override
    public List<Person> getAll() throws SQLException {
        Connection con = connectionPool.getConnection();
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM person";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt("id"));
                    person.setPersonName(rs.getString("person_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setPhone(rs.getString("phone"));
                    person.setAddress(rs.getString("address"));
                    persons.add(person);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            connectionPool.releaseConnection(con);
        }
        return persons;
    }

    @Override
    public Person get(int id) throws SQLException {
        Connection con = connectionPool.getConnection();
        Person person = new Person();
        String query = "SELECT * FROM person WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);

            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    person.setId(rs.getInt("id"));
                    person.setPersonName(rs.getString("person_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setPhone(rs.getString("phone"));
                    person.setAddress(rs.getString("address"));
                }
            } catch (SQLException e) {
                throw new RuntimeException();
            } finally {
                connectionPool.releaseConnection(con);
            }
        }
        return person;
    }
}