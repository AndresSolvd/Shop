import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTry {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/mydb";
        String uname = "root";
        String password = "H_7n9fpF9vW66yf";
        String query = "SELECT * FROM person";
        String query2 = "INSERT INTO person(person_name, last_name, phone, address) values('Bart', 'Simpson', '1234561235', '342 noway Springfield')";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection con = DriverManager.getConnection(url, uname, password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String theData = "";
                for (int i =1; i <= 6; i ++) {
                    theData += result.getString(i) + ":";
                }
                System.out.println(theData);
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

    }
}
