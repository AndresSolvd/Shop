package com.solvd.util;

import com.solvd.sql.model.Shop;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParserTwo {

    public static void parser(String xmlFilePath) {

        try {
            // Load XML file
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Create  object
            Shop shop = new Shop();

            // Access elements using DOM methods
            Element shopElement = (Element) doc.getElementsByTagName("shop").item(0);
            shop.setId(Integer.parseInt(shopElement.getElementsByTagName("id").item(0).getTextContent()));
            shop.setShopName(shopElement.getElementsByTagName("shop_name").item(0).getTextContent());
            shop.setAddress(shopElement.getElementsByTagName("address").item(0).getTextContent());
            shop.setPhone(shopElement.getElementsByTagName("phone").item(0).getTextContent());
            shop.setOwnerId(Integer.parseInt(shopElement.getElementsByTagName("owner_id").item(0).getTextContent()));

            // Print the parsed values
            System.out.println("Shop ID: " + shop.getId());
            System.out.println("Shop Name: " + shop.getShopName());
            System.out.println("Address: " + shop.getAddress());
            System.out.println("Phone: " + shop.getPhone());
            System.out.println("Owner ID: " + shop.getOwnerId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
