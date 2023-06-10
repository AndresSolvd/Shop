package com.solvd.sql.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class MarshOrUnMarsh {

    public static void marshItAll() {
        String packageName = "com.solvd.sql.model";
        List<Class<?>> classes = getClasses(packageName);

        for (Class<?> clazz : classes) {
            marshall(clazz);
        }
    }

    public static void unmarshItAll() {
        String packageName = "com.solvd.sql.model";
        List<Class<?>> classes = getClasses(packageName);

        for (Class<?> clazz : classes) {
            unmarshall(clazz);
        }
    }

    public static void marshall(Class<?> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Generate the XML file name using the class name
            String fileName = "src/main/resources/XMLFiles/" + clazz.getSimpleName() + ".xml";

            // Create an instance
            Object instance = clazz.getDeclaredConstructor().newInstance();

            // Marshal the instance to XML and save it to the file
            marshaller.marshal(instance, new File(fileName));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void unmarshall(Class<?> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Generate the XML file name using the class name
            String fileName = "src/main/resources/XMLFiles/" + clazz.getSimpleName() + ".xml";

            // Unmarshal on an object
            Object instance = unmarshaller.unmarshal(new File(fileName));

            System.out.println(instance);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }

    // Get all Classes
    public static List<Class<?>> getClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources = null;
        try {
            resources = classLoader.getResources(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<Class<?>> classes = new ArrayList<>();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            File file = new File(resource.getFile());
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        String fileName = f.getName();
                        if (fileName.endsWith(".class")) {
                            String className = packageName + "." + fileName.substring(0, fileName.length() - 6);
                            Class<?> clazz = null;
                            try {
                                clazz = Class.forName(className);
                            } catch (ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            classes.add(clazz);
                        }
                    }
                }
            }
        }
        return classes;
    }
}
