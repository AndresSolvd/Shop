package TestDelete;

import com.solvd.sql.model.Person;
import com.solvd.util.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class ThirdMain {

    public static void main(String[] args) throws SQLException {
        IPerson hola = new SecondImplement();
        Person eshola = hola.get(3);
        System.out.println(eshola);
    }
}
