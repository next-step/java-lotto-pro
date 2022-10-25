package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String delimiterRegex = "[,:]";
    private static final String customDelimiterRegex = "//(.)\n(.*)";
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) return 0;
        if (isSingleNumber(text)) return parseInt(text);
        String[] splitArray = split(text);
        
        return sumStringArray(splitArray);
    }
    
    private static boolean isNullOrEmpty(String text){
        return text == null || text.trim().isEmpty();
    }
    
    private static String[] splitByDelimiter(String text) {
        return text.split(delimiterRegex);
    }
    
    private static String[] splitByCustomPattern(Matcher m) {
        String customDelimiter = m.group(1);
        return m.group(2).split(customDelimiter);
    }
    private static boolean isSingleNumber(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    private static String[] split(String text) {
        Matcher m = Pattern.compile(customDelimiterRegex).matcher(text);
        if (m.find()) {
            return splitByCustomPattern(m);
        }
        return splitByDelimiter(text);
      
    }
    
    private static int sumStringArray(String[] splitArray) {
        int result = 0;
        for(String value : splitArray){
            if(isSingleNumber(value)) result += parseInt(value);
        }
        return result;
    }
    
    private static int parseInt(String text){
        int result = Integer.parseInt(text);
        checkNegative(result);
        
        return result;
    }
    
    private static void checkNegative(Integer value){
        if (value < 0) throw new RuntimeException();
    }
}
