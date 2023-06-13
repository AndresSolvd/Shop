package com.solvd.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSONExtractor {

    public static String extractClassName(String fileName) {

        Pattern pattern = Pattern.compile("^([a-z]|[A-Z])+");
        Matcher matcher = pattern.matcher(fileName);

        if (matcher.find()) {
            return Character.toUpperCase(matcher.group().charAt(0)) + matcher.group().substring(1);
        }
        return "";
    }
}
