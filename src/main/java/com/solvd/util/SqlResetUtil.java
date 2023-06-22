package com.solvd.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlResetUtil {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();

    public static void reset() {
        try {
            Connection con = connectionPool.getConnection();
            Statement statement = con.createStatement();

            // DELETE statements
            statement.executeUpdate("DELETE FROM order_item;");
            statement.executeUpdate("DELETE FROM orders;");
            statement.executeUpdate("DELETE FROM product_promotion;");
            statement.executeUpdate("DELETE FROM promotion;");
            statement.executeUpdate("DELETE FROM product;");
            statement.executeUpdate("DELETE FROM supplier;");
            statement.executeUpdate("DELETE FROM category;");
            statement.executeUpdate("DELETE FROM customer;");
            statement.executeUpdate("DELETE FROM staff;");
            statement.executeUpdate("DELETE FROM shop;");
            statement.executeUpdate("DELETE FROM owner;");
            statement.executeUpdate("DELETE FROM person;");

            // ALTER statements
            statement.executeUpdate("ALTER TABLE customer AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE owner AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE staff AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE person AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE shop AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE category AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE supplier AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE orders AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE promotion AUTO_INCREMENT = 1;");
            statement.executeUpdate("ALTER TABLE product AUTO_INCREMENT = 1;");

            statement.close();
            con.close();

            System.out.println("All tables were reset successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
