package com.solvd;

import com.solvd.util.TestConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        int id = 1;
        System.out.println(id);

        Connection conn = TestConnection.getConnection();

        String sql = "SELECT id FROM person WHERE id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int oid = rs.getInt("id");
            System.out.println(oid);
        }
    }
}
