package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String COMMA = ",";

    public static int splitAndSum(String str) throws MyOwnRuntimeException {
        int result = 0;
        if( str == null || str.isEmpty() ) return result;
        if( str.length() == 1 ) return checkOneNumber(str);
        if( str.contains(COMMA) && !str.contains(":")) return checkComma(str);
        if(str.contains(COMMA) && str.contains(":") ) return checkCommaAndDelimiter(str);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
        if(m.find()) return checkCustomDelimiter(m);
        return result;
    }

    private static int checkOneNumber(String str) {
        return Integer.parseInt(str);
    }

    private static int checkComma(String str) throws MyOwnRuntimeException {
        String[] token = str.split(COMMA);
        return addStringArray(token);
    }

    private static int checkCommaAndDelimiter(String str) throws MyOwnRuntimeException {
        String[] token = str.split(",|:");
        return addStringArray(token);
    }

    private static int checkCustomDelimiter(Matcher m) throws MyOwnRuntimeException {
        String customDelimiter = m.group(1);
        String[] tokens= m.group(2).split(customDelimiter);
        return addStringArray(tokens);
    }

    private static int addStringArray(String[] strs) throws MyOwnRuntimeException {
        int result = 0;
        for(String str : strs) {
            result += checkInt(Integer.parseInt(str));
        }
        return result;
    }

    private static int checkInt(int number) throws MyOwnRuntimeException {
        if( number < 0 ) throw new MyOwnRuntimeException();
        return number;
    }

    private StringAddCalculator(){}
}
