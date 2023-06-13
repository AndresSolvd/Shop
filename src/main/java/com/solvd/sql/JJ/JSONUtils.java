package com.solvd.sql.JJ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.Paths;
import com.solvd.util.JSONExtractor;

import java.io.File;
import java.io.IOException;

public class JSONUtils {

    public static void writeJSON(Object object) {
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(new File(Paths.JSONFOLDER.getPath() + object.getClass().getSimpleName() + ".json"), object);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    // Input assumes the class name is the first String. Name convention would be class name follow by a number
    public static Object readJSON(String filename) {
        try {
            String className = JSONExtractor.extractClassName(filename);
            Class<?> objectClass = Class.forName(Paths.MODELFOLDER.getPath() + "." + className);
            ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            return objectMapper.readValue(new File(Paths.JSONFOLDER.getPath() + objectClass.getSimpleName() + ".json"), objectClass);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



/*    public static Shop readJSON() {
        Shop shop;
        ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try{
            shop = objectMapper.readValue(new File(Paths.JSONFOLDER.getPath() + "shop.json"), Shop.class);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return shop;
    }*/
}
