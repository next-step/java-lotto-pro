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
        return Arrays.stream(split).mapToInt(Integer::parseInt).sum();
    }

    private boolean isValid(String input) {
        return input == null || input.isEmpty();
    }

}
