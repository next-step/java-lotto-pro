package step2;

public class StringAdditionCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    public static int addAllDelimiterString(final String numberWithDelimiter) {
        final String[] numbers = numberWithDelimiter.split(DEFAULT_DELIMITER);
        int sum = 0;
        for (final String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
