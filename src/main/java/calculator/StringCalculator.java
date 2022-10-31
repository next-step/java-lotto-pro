package calculator;

public class StringCalculator {

    private static final int NOT_CALCULATED = 0;

    private StringCalculator() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static int calculate(String input) {
        if (isNotCalculated(input)) {
            return NOT_CALCULATED;
        }
        return PositiveOperandBag.sum(Separator.separate(input));
    }

    private static boolean isNotCalculated(String input) {
        return input == null || input.trim().equals("");
    }
}
