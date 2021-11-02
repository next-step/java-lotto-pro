import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitInputText {

    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static final String COMMA_OR_COLON = ",|:";

    public static String[] splitCustomDelimiter(String inputText) {
        String[] numbers = {};
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        }
        return numbers;
    }

    public static String[] splitCommaOrColon(String inputText) {
        return inputText.split(COMMA_OR_COLON);
    }
}
