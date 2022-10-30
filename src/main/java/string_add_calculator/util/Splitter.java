package string_add_calculator.util;

import string_add_calculator.domain.Numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String customParserRegEx = "^//(.)\n(.*)$";
    private static final int customDelimiterGroupIndex = 1;
    private static final int numberStringIndex = 2;

    private Splitter(){}

    public static Numbers split(String text) {
        return Numbers.of(parse(text).split());
    }

    private static ParseData parse(String text) {
        Matcher m = Pattern.compile(customParserRegEx).matcher(text);
        if(m.find()){
            return ParseData.of(m.group(customDelimiterGroupIndex),m.group(numberStringIndex));
        }
        return ParseData.of("",text);
    }
}
