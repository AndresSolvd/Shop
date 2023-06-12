package com.solvd.sql.jaxb;

import com.solvd.sql.model.Shop;
import com.solvd.util.XMLTagExtractor;
import com.solvd.sql.model.Person;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class Simple {

    public static Shop unMarshall() {
        Shop shop;
        try{
            JAXBContext context = JAXBContext.newInstance(Shop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            shop = (Shop)   unmarshaller.unmarshal(new File("src/main/resources/XMLFiles/Category.xml"));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return shop;
    }

    public static Object unmarShall(String filePath) {
        try {
            String clazz = XMLTagExtractor.fileExtractor(filePath);
            clazz = Character.toUpperCase(clazz.charAt(0)) + clazz.substring(1);
            Class<?> objectClass = Class.forName("com.solvd.sql.model." + clazz);
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return objectClass.cast(unmarshaller.unmarshal(new File(filePath)));
        } catch (JAXBException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }




    public static <T> T unmarshall(Class<T> objectClass, String filePath) {
        T instance;
        try {
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            instance = objectClass.cast(unmarshaller.unmarshal(new File(filePath)));
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        System.out.println(instance);
        return instance;

    }





}
