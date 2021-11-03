public class ValidationUtils {

    public static final int NUMBER_ZERO = 0;

    public static void checkValidateNumber(String number) {
        if (Integer.parseInt(number) < NUMBER_ZERO) {
            throw new RuntimeException();
        }
    }
}
