package util;

import domain.SafeString;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterParser {
    private static final String customParserRegEx = "^//(.)\n(.*)$";

    public static CustomDelimiterParseResult parse(SafeString s) {
        Matcher m = Pattern.compile(customParserRegEx).matcher(s.toString());
        if(m.find()){
            return CustomDelimiterParseResult.of(m.group(1),m.group(2));
        }
        return CustomDelimiterParseResult.of("",s.toString());
    }
}
