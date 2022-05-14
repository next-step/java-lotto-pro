package calculator;

import java.util.Arrays;

public class Calculator {

    private static final String REGEX_CHECK_NUMBER = "[0-9]+";

    private final int[] addTargets;

    public Calculator(String[] arguments) {
        this.addTargets = checkValidation(arguments);
    }

    public int sum() {
        return Arrays.stream(this.addTargets).sum();
    }

    private int[] checkValidation(String[] arguments) {
        for (String argument : arguments) {
            checkNotAvailable(argument);
        }
        return Arrays.stream(arguments).mapToInt(Integer::parseInt).toArray();
    }

    private void checkNotAvailable(String argument) {
        if (!argument.matches(REGEX_CHECK_NUMBER)) {
            throw new RuntimeException("숫자만 입력해주세요.");
        }

        if (Integer.parseInt(argument) < 0) {
            throw new RuntimeException("음수는 계산할 수 없습니다.");
        }
    }
}
