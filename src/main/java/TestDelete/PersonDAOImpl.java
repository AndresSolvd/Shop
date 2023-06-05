package TestDelete;

import com.solvd.sql.model.Person;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PersonDAOImpl implements IPerson {


    @Override
    public void insert(Person person) throws SQLException {

    }

    @Override
    public Person get(int id) throws SQLException {
        Connection con = Database.getConnection();
        Person person = null;

        String sql = "SELECT id, person_name FROM person WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1,id);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int oid = rs.getInt("id");
            String name = rs.getString("person_name");

            person = new Person();
            person.setId(oid);
            person.setPersonName(name);
        }
        return person;
    }

    @Override
    public void update(Person person) throws SQLException {

    }

    @Override
    public void delete(Person person) {

    }

    @Override
    public List<Person> getAll() throws SQLException {
        return null;
    }
}
