package calculator;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final static Pattern SPLITER = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher matcher = SPLITER.matcher(input);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            return Arrays.stream(matcher.group(2).split(customDelimiter))
                .mapToInt(Integer::parseInt)
                .sum();
        }
        return Arrays.stream(input.split("[,:]"))
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
