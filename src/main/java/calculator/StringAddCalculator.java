package calculator;

import static utlis.StringUtils.isNullOrEmpty;
import static utlis.StringUtils.toInt;

public class StringAddCalculator {

    private static final String DEFAULT_SEPARATORS = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        String[] splitText = splitText(text);

        return sumSplitText(splitText);
    }

    private static int sumSplitText(String[] splitText) {
        // TODO: 나눠진 구분자의 값이 숫자 이외의 값 또는 음수인 경우 Exception 발생 조건 추가
        int sum = 0;
        for (String text : splitText) {
            sum += convertPositiveNumber(text);
        }
        return sum;
    }

    private static int convertPositiveNumber(String text) {
        int number = toInt(text);
        if (number < 0) {
            throw new RuntimeException("문자열 계산기에 음수는 올 수 없습니다.");
        }
        return number;
    }

    private static String[] splitText(String text) {
        return text.split(DEFAULT_SEPARATORS);
        // TODO: custom pattern이 오는 경우 조건 추가
    }
}
