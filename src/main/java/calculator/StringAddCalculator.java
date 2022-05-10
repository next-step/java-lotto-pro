package calculator;

import calculator.util.SplitUtils;
import calculator.util.StringUtils;
import java.util.Arrays;


public class StringAddCalculator {

    private static final String BASIC_SEPERATER = ",|:";
    private static final int ZERO = 0;

    public static int splitAndSum(String text) {
        if (StringUtils.isEmptyString(text)) {
            return 0;
        }
        return sum(text);
    }

    private static void validNegativeArray(int[] array) {
        if (Arrays.stream(array)
                .filter((v) -> v < ZERO)
                .findFirst().isPresent()) {
            throw new RuntimeException("문자열 계산기에는 음수를 전달할 수 없습니다.");
        }
    }

    private static int sum(String text) {
        int[] intArray = SplitUtils.splitToInt(text, BASIC_SEPERATER);
        validNegativeArray(intArray);
        return Arrays.stream(intArray).sum();
    }

}
