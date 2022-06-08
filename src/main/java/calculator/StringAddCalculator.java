package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        String[] numbers = StringSeparator.split(StringUtils.readString(input));
        return new Numbers(numbers).sum();
    }
}
