package com.solvd.util;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class XMLExtractor {

    public static String getMainNodeName(String filePath) {

        String extractedString = "";
        try {
            String xmlContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
            extractedString = extractLastTagContent(xmlContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return extractedString;
    }

    private static String extractLastTagContent(String xmlContent) {
        Pattern pattern = Pattern.compile("(?<=\\<)(\\w+)");
        Matcher matcher = pattern.matcher(xmlContent);

        if (matcher.find()) {
            return matcher.group(1);
        } else {
            return "";
        }
    }
}
