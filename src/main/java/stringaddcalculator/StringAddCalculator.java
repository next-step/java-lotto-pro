package stringaddcalculator;

public class StringAddCalculator {

    public static final int ZERO = 0;
    public static final String COMMA = ",";

    public static int splitAndSum(final String text) {
        if (validateNullOrEmpty(text)) {
            return ZERO;
        }

        final String[] splitTexts = splitText(text);
        final int[] numbers = parsingNumbers(splitTexts);

        return sumNumbers(numbers);
    }

    private static boolean validateNullOrEmpty(final String text) {
        if (text == null) {
            return true;
        }
        return text.isEmpty();
    }

    private static String[] splitText(final String text) {
        return text.split(COMMA);
    }

    private static int[] parsingNumbers(final String[] splitTexts) {
        final int length = splitTexts.length;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = parseInteger(splitTexts[i]);
        }

        return numbers;
    }

    private static int parseInteger(final String splitTexts) {
        return Integer.parseInt(splitTexts);
    }

    private static int sumNumbers(final int[] numbers) {
        int sum = 0;

        for (final int number : numbers) {
            sum += number;
        }

        return sum;
    }

}
