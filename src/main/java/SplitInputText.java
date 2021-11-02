import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitInputText {

    public static String[] splitCustomDelimiter(String inputText) {
        String[] numbers = {};
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            numbers = m.group(2).split(customDelimiter);
        }
        return numbers;
    }

    public static String[] splitCommaOrColon(String inputText) {
        return inputText.split(",|:");
    }
}
