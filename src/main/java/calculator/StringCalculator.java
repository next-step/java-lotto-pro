package calculator;

public class StringCalculator {
    public int splitAndSum(String input) {
        PositiveNumbers positiveNumbers = new PositiveNumbers(input);
        return positiveNumbers.sum();
    }
}
