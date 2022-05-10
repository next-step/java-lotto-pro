package stringaddcalculator;

public class StringAddCalculator {
    public static int splitAndSum(final String text) {
        if (validateNullOrEmpty(text)) {
            return 0;
        }

        throw new RuntimeException("문자열 계산을 할 수 없습니다.");
    }

    private static boolean validateNullOrEmpty(final String text) {
        if (text == null) {
            return true;
        }
        return text.isEmpty();
    }

}
