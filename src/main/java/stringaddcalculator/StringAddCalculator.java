package stringaddcalculator;

public class StringAddCalculator {
    public static Integer calculate(String value) {
        Integer result = 0;
        InputString inputString = new InputString(value);

        for (Integer number : inputString.getNumbers()) {
            result += number;
        }

        return result;
    }
}
