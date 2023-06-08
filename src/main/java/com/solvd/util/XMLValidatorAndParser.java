package com.solvd.util;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class XMLValidatorAndParser {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/shop.xml";
        String xsdFilePath = "src/main/resources/shop.xsd";

        try {
            boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
            if (isValid) {
                // Process the validated and parsed XML document as needed
                System.out.println("XML is valid and parsed successfully.\n");
                DOMParser(xmlFilePath);
            } else {
                System.out.println("XML is not valid against the XSD.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean validateXMLAgainstXSD(String xmlFilePath, String xsdFilePath) {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(xsdFilePath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlFilePath));
            return true; // XML is valid against the XSD
        } catch (Exception e) {
            e.printStackTrace();
            return false; // XML is not valid against the XSD
        }
    }

    public static void DOMParser(String xmlFilePath) {
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