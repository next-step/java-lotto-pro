import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFactory {

    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final String COMMA_OR_COLON = ",|:";
    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_COMPILER = Pattern.compile(CUSTOM_DELIMITER_PATTERN);

    public static String[] createNumberArray(String inputText) {
        String[] numbers = {};
        if (CUSTOM_DELIMITER_COMPILER.matcher(inputText).matches()){
            Matcher m = CUSTOM_DELIMITER_COMPILER.matcher(inputText);
            if (m.find()) {
                String customDelimiter = m.group(1);
                numbers = m.group(2).split(customDelimiter);
            }
            return numbers;
        }
         return NumberFactory.splitCommaOrColonDelimiter(inputText);
    }

    public static String[] splitCommaOrColonDelimiter(String inputText) {
        if (inputText.contains(COMMA) || inputText.contains(COLON)) {
            return inputText.split(COMMA_OR_COLON);
        }
        return new String[] {inputText};
    }
}
