package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        String[] split = StringSeparator.split(StringUtils.readString(input));
        Numbers numbers = new Numbers(split);
        return numbers.sum();
    }
}
