package com.solvd.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {

    private static ConnectionPool instance = null;
    private static final int INITIAL_POOL_SIZE = 5;
    private static Vector<Connection> freeConnections = new Vector<>();
    private static Vector<Connection> usedConeections = new Vector<>();

    private ConnectionPool(){

    }

    public static synchronized ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool();
        create();
        }
        return instance;
    }

    public static void create() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i ++) {
            freeConnections.add(createConnection(DBConfig.URL, DBConfig.USERNAME, DBConfig.PASSWORD));
        }
    }

    public synchronized Connection getConnection() {
        Connection connection = freeConnections.remove(freeConnections.size() -1);
        usedConeections.add(connection);
        return connection;
    }

    public synchronized void releaseConnection(Connection connection) throws SQLException {
        if(usedConeections.remove(connection)) {
            freeConnections.add(connection);
        } else {
            throw new SQLException("The connection has already returned or it's not for this pool.");
        }
    }

    private static Connection createConnection(String url, String username, String password) {
        try{
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
