package stringAddCalculator.Utils;

public class Validation {
    public static boolean isNotNullAndEmpty(String input) {
        if (input == null) {
            return true;
        }

        if (input.isEmpty()) {
            return true;
        }
        return false;
    }

    public static boolean isNumberAndSizeOne(String input) {
        if (!input.matches("^[0-9]")) {
            throw new RuntimeException();
        }
        return true;
    }
}
