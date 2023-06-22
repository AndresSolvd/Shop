package com.solvd.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqlResetUtil {
    private static final ConnectionPool connectionPool = ConnectionPool.getInstance();
    private static final List<String> tableNames = List.of(
            "order_item", "orders", "product_promotion", "promotion", "product",
            "supplier", "category", "customer", "staff", "shop", "owner", "person"
    );

    public static void reset() {
        try {
            Connection con = connectionPool.getConnection();
            Statement statement = con.createStatement();

            // DELETE statements
            for (String tableName : tableNames) {
                statement.executeUpdate("DELETE FROM " + tableName + ";");
            }

            // ALTER statements
            for (String tableName : tableNames) {
                statement.executeUpdate("ALTER TABLE " + tableName + " AUTO_INCREMENT = 1;");
            }

            statement.close();
            con.close();

            System.out.println("All tables were reset successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
