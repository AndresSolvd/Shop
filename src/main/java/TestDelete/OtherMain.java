package TestDelete;

import com.solvd.sql.model.Person;

import java.sql.Connection;
import java.sql.SQLException;

public class OtherMain {
    public static void main(String[] args) throws SQLException {
        Connection con = Database.getConnection();



        IPerson personDao = new PersonDAOImpl();
        Person person = personDao.get(3);
        System.out.println(person);
    }
}
