package calculator;

public class StringAddCalculator {

    private StringAddCalculator() {
    }

    public static int input(String number) {
        if (isNotValidNumber(number)) {
            return 0;
        }

        return 0;
    }

    private static boolean isNotValidNumber(String number) {
        return isNull(number) || isEmpty(number);
    }

    private static boolean isEmpty(String number) {
        return number.trim().isEmpty();
    }

    private static boolean isNull(String number) {
        return number == null;
    }
}
