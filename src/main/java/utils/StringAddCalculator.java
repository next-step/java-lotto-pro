package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static int DEFAULT_VALUE = 0;
    private static String DELIMITERS = ",|:";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if(isTextNullOrEmpty(text)){
            return DEFAULT_VALUE;
        }
        String[] texts = split(text);
        return sum(texts);
    }

    private static boolean isTextNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text){
        Matcher m = PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITERS);
    }

    private static int sum(String[] texts){
        int sum = DEFAULT_VALUE;
        for (String text: texts){
            sum += parseInt(text);
        }
        return sum;
    }

    private static int parseInt(String text){
        if(Integer.parseInt(text) < DEFAULT_VALUE){
            throw new RuntimeException();
        }
        return Integer.parseInt(text);
    }

}
