package calculator.util;

public class Common {

    public static boolean validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            return true;
        }
        return false;
    }
}
