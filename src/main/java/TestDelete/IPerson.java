package TestDelete;

import com.solvd.sql.interfaces.IDao;
import com.solvd.sql.model.Person;

import java.sql.SQLException;

public interface IPerson extends IDao<Person> {
    Person get(int id) throws SQLException;

}
