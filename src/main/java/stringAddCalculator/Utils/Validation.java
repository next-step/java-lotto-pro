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
}
