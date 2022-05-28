package util;

public class ValidationUtil {
    public static void validateCorrectArguments(boolean validateCondition, String exceptionMessage) {
        if (validateCondition) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
