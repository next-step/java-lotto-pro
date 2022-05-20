package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Numbers numbers = new Numbers(input);
        return numbers.sum();
    }
}
