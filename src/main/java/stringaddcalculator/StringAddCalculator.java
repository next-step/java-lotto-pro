package stringaddcalculator;

public class StringAddCalculator {
    public static Integer calculate(String value) {
        Integer result = 0;
        Numbers numbers = new Numbers(value);

        for (Integer number : numbers.getNumbers()) {
            result += number;
        }

        return result;
    }
}
