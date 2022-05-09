package step2;

public class StringAddCalculator {

    public int calculate(String input) {
        if (input == null) {
            return 0;
        }

        if (input.isEmpty()) {
            return 0;
        }

        if (isSingleDigitNumber(input)) {
            return Integer.valueOf(input);
        }

        return -1;
    }

    boolean isSingleDigitNumber(String input) {
        try {
            Integer.valueOf(input);
            return input.length() == 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
