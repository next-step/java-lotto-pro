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
        return sum(split(input));
    }

    private static String[] split(final String input){
        Matcher matcher = SPLITER.matcher(input);
        if(matcher.find()){
            String customDelimiter = matcher.group(1);
            String string = matcher.group(2);
            return string.split(customDelimiter);
        }
        return input.split("[,:]");
    }

    private static int sum(final String[] input) {
        return Arrays.stream(input)
            .mapToInt(Integer::parseInt)
            .sum();
    }
}
