package calculator;

public class StringAddCalculator {

    public static int splitAndSum(String input) {
        Numbers numbers = new Numbers(input);
        return numbers.sum();
    }

}
