package com.solvd.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBConfig {

    private static final Properties properties;

    static {
        properties = new Properties();
        try (InputStream inputStream = DBConfig.class.getResourceAsStream("/db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("user");
    public static final String PASSWORD = properties.getProperty("password");
}
