package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        int sum = 0;
        Numbers numbers = StringSeparator.split(input);
        for (Number number : numbers.list()) {
            sum += number.value();
        }
        return sum;
    }
}
