package calculator;

import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String IS_NOT_DUAL_NUMBER_ERROR_MESSAGE = "입력 값이 음수이거나 숫자가 아닙니다.";
    public static final String IS_NUMBER_REGEX = "[0-9]+";
    public static final Pattern DUAL_NUMBER_PATTERN = Pattern.compile(IS_NUMBER_REGEX);

    private StringAddCalculator() {
    }

    public static int splitAndSum(String inputs) {
        Input input = new Input(inputs);

        if (input.isNullOrEmpty()) {
            return 0;
        }

        String[] splitInputs = input.split();

        return sum(splitInputs);
    }

    private static int sum(String[] splitInputs) {
        int result = 0;

        for (String number : splitInputs) {
            result += convertStringToInteger(number);
        }

        return result;
    }

    private static int convertStringToInteger(String number) {
        if (!DUAL_NUMBER_PATTERN.matcher(number).matches()) {
            throw new RuntimeException(IS_NOT_DUAL_NUMBER_ERROR_MESSAGE);
        }
        return Integer.parseInt(number);
    }

}
