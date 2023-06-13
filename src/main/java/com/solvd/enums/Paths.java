package com.solvd.enums;

public enum Paths {

    XMLFOLDER("src/main/resources/XMLFolder/"),
    MODELFOLDER("com.solvd.sql.model"),
    JSONFOLDER("src/main/resources/JSONFolder/");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
