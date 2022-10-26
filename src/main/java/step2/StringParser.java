package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringParser {


    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static int[] parseToIntArray(String text){
        String[] tokens = parseToStringArray(text);
        return Stream.of(tokens).mapToInt(Integer::parseInt).toArray();
    }


    public static String[] parseToStringArray(String text){
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if(matcher.find()) {
            return matcher.group(2).split(matcher.group(1));
        }
        return text.split(DEFAULT_DELIMITER);
    }
}
