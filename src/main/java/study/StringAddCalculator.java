package study;

public class StringAddCalculator {
    private static final int ZERO = 0;
    public static int splitAndSum(String input) {
        if (isNullOrEmpty(input)) {
            return ZERO;
        }
        if (isOnceNumber(input)) {
            return Integer.parseInt(input);
        }

        return 1;
    }

    public static boolean isNullOrEmpty(String input) {
        if (input == null) {
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isOnceNumber(String input) {
        if (input.length() > 1) {
            return false;
        }
        if (input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        return false;
    }

    public static boolean isStringOrNegativeNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            return true;
        }
        if (Integer.parseInt(input) < 0) {
            return true;
        }
        return false;
    }
}
