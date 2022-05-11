package stringAddCalculator.Utils;

public class Validation {
    public static boolean isNotNullAndEmpty(String input) {
        if (input == null) {
            return false;
        }

        if (input.isEmpty()) {
            return true;
        }
        return false;
    }
}
