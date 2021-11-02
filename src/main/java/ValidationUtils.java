public class ValidationUtils {
    public static void checkValidateNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException();
        }
    }
}
