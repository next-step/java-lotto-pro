package util;

import domain.Numbers;
import domain.SafeString;

public class Splitter {
    private static final String defaultDelimiter = ",|:";

    public static Numbers split(SafeString s) {
        CustomDelimiterParseResult result = CustomDelimiterParser.parse(s);
        String delimiter = getDelimiter(result.getCustomDelimiter());
        String[] split = result.getNumberString().split(delimiter);
        return Numbers.of(split);
    }

    private static String getDelimiter(String customDelimiter) {
        String delimiter = defaultDelimiter;
        if(!customDelimiter.isEmpty()){
            delimiter = String.format("%s|%s",defaultDelimiter,customDelimiter);
        }
        return delimiter;
    }



}
