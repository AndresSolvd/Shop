package com.solvd;

public enum Paths {

    XMLFOLDER("src/main/resources/XMLFolder/"),
    MODELFOLDER("com.solvd.sql.model");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}