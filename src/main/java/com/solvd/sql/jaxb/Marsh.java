package com.solvd.sql.jaxb;

import com.solvd.sql.model.Category;
import com.solvd.sql.model.Shop;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Marsh {

    public static void marshall(Category category) {
        try {
            JAXBContext context = JAXBContext.newInstance(Category.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(category, new File("src/resources/shopTest"));
        } catch (JAXBException e) {
            throw new RuntimeException();
        }
    }

    public static void unmarshall() {
        Shop shop;
        try {
            JAXBContext context = JAXBContext.newInstance(Shop.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            shop = (Shop) unmarshaller.unmarshal(new File(System.getProperty("user.dir" + "src/resources/shopTest2")));
        } catch (JAXBException e) {
            throw new RuntimeException();
        }
    }
}
