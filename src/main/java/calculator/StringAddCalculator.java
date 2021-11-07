package calculator;

public class StringAddCalculator {
    public static int calculate(String input) {
        if ("".equals(input) || input == null) {
            return 0;
        }
        String[] split = StringSplitter.split(input);
        Numbers numbers = new Numbers(split);
        return numbers.sum();
    }

}
