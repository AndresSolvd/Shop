package com.solvd.enums;

public enum Paths {

    XMLFOLDER("src/main/resources/xml/"),
    MODELFOLDER("com.solvd.sql.model"),
    JSONFOLDER("src/main/resources/json/"),
    SHOPXML("src/main/resources/xmlXsd/shop.xml"),
    SHOPXSD("src/main/resources/xmlXsd/shop.xsd");

    private final String path;

    Paths(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
