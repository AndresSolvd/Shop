package com.solvd.sql.jaxb;

import com.solvd.Paths;
import com.solvd.util.XMLExtractor;

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

public class JAXBUtils {

    public static void printAllXMLFiles() {
        String packageName = Paths.MODELFOLDER.getPath();
        List<Class<?>> classes = getClasses(packageName);

        for (Class<?> clazz : classes) {
            String fileName = Paths.XMLFOLDER.getPath() + clazz.getSimpleName() + ".xml";
            System.out.println(unMarshall(fileName));
        }
    }

    public static void marshall(Object object) throws JAXBException {
        try {
            JAXBContext context = JAXBContext.newInstance(object.getClass());
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, new File(Paths.XMLFOLDER.getPath() + object.getClass().getSimpleName() + ".xml"));
        } catch (JAXBException e) {
            throw new JAXBException(e);
        }
    }

    public static Object unMarshall(String filePath) {
        try {
            String clazz = XMLExtractor.getMainNodeName(filePath);
            clazz = Character.toUpperCase(clazz.charAt(0)) + clazz.substring(1);
            Class<?> objectClass = Class.forName(Paths.MODELFOLDER.getPath() + "." + clazz);
            JAXBContext context = JAXBContext.newInstance(objectClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return objectClass.cast(unmarshaller.unmarshal(new File(filePath)));
        } catch (JAXBException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // Get all Classes
    public static List<Class<?>> getClasses(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        Enumeration<URL> resources;
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
                            Class<?> clazz;
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
