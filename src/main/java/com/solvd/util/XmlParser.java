package com.solvd.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XmlParser {
    public static void parser(String xmlFilePath) {
        try {
            // Load XML file
            File xmlFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Access elements using DOM methods
            Element shopElement = (Element) doc.getElementsByTagName("shop").item(0);
            String shopId = shopElement.getElementsByTagName("id").item(0).getTextContent();
            String shopName = shopElement.getElementsByTagName("shop_name").item(0).getTextContent();
            String address = shopElement.getElementsByTagName("address").item(0).getTextContent();
            String phone = shopElement.getElementsByTagName("phone").item(0).getTextContent();
            String ownerId = shopElement.getElementsByTagName("owner_id").item(0).getTextContent();

            // Print the parsed values
            System.out.println("Shop ID: " + shopId);
            System.out.println("Shop Name: " + shopName);
            System.out.println("Address: " + address);
            System.out.println("Phone: " + phone);
            System.out.println("Owner ID: " + ownerId);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
