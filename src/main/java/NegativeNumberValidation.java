public class NegativeNumberValidation {

    public static final int NUMBER_ZERO = 0;

    public static void isNegative(String number) {
        if (stringToNumber(number) < NUMBER_ZERO) {
            throw new RuntimeException();
        }
    }

    private static int stringToNumber(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }
}
