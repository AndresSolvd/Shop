package com.solvd.util;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class XMLValidatorAndParser {

    public static void main(String[] args) {
        String xmlFilePath = "src/main/resources/shop.xml";
        String xsdFilePath = "src/main/resources/shop.xsd";

        try {
            boolean isValid = validateXMLAgainstXSD(xmlFilePath, xsdFilePath);
            if (isValid) {
                // Process the validated and parsed XML document as needed
                System.out.println("XML is valid and parsed successfully.");
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
}