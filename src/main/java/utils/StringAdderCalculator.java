package utils;

import static java.lang.String.format;

public class StringAdderCalculator {

    public static int sum(String text) {
        SplitStrings splitNumbers = StringSplitter.split(text);

        verifyIsInvalidText(splitNumbers);

        return sum(splitNumbers);
    }

    private static void verifyIsInvalidText(SplitStrings splitNumbers) {
        splitNumbers.stream()
            .filter(StringAdderCalculator::isInvalidText)
            .findAny()
            .ifPresent((nonDigit) -> {
                throw new RuntimeException(format("숫자 이외의 값 또는 음수를 입력할 수 없습니다, 입력값=%s", nonDigit));
            });
    }

    private static boolean isInvalidText(String text) {
        return isNonDigit(text) || isNegativeNumber(text);
    }

    private static boolean isNegativeNumber(String text) {
        try {
            return Integer.parseInt(text) < 0;
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean isNonDigit(String text) {
        try {
            Integer.parseInt(text);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static int sum(SplitStrings splitNumbers) {
        return splitNumbers.stream()
                .map(Integer::parseInt)
                .mapToInt(Integer::intValue).sum();
    }

}
