package step2;

public class StringValidator {
    public static boolean isNullOrEmptyString(final String numberWithDelimiter) {
        return numberWithDelimiter == null || numberWithDelimiter.equals("");
    }
}
