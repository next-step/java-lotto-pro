package stringcalculator;

import java.util.Arrays;

public class StringCalculator {

    private final SplitUtils splitUtils;

    public StringCalculator() {
        this.splitUtils = new SplitUtils();
    }

    public int calculate(String input) {
        if (isValid(input)) {
            return 0;
        }
        String[] split = splitUtils.splitByDelimiter(input);
        return Arrays.stream(split).mapToInt(this::parse).sum();
    }

    private boolean isValid(String input) {
        return input == null || input.isEmpty();
    }

    private int parse(String numberString) {
        int number = parseStringToInt(numberString);;
        checkLessThanZero(number);
        return number;
    }

    private int parseStringToInt(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException ex) {
            throw new IllegalArgumentException("숫자로 변환할 수 없습니다.");
        }
    }

    private void checkLessThanZero(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("숫자는 0보다 커야합니다.");
        }
    }

}
