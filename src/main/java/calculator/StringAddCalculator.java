package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)){ return 0; }
        return sum(split(text));
    }
    private static String[] split(String text){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split("[,:]");
    }
    private static int sum(String[] numbers){
        return Stream.of(numbers)
                .mapToInt(Integer::parseInt)
                .peek(StringAddCalculator::isValid)
                .sum();
    }
    private static void isValid(int number){
        if(number < 0)
            throw new RuntimeException();
    }
    private static boolean isNullOrEmpty(String text){
        return text == null || text.isEmpty();
    }
}
