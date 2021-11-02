package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] numbers = TextSplit.split(text);
        PositiveNumbers positiveNumbers = new PositiveNumbers(numbers);
        return positiveNumbers.sum();
    }
}
