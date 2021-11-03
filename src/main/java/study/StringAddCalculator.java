package study;

public class StringAddCalculator {

    public static int splitAndSum(final String text) {
        if (isEmptyOrNull(text)) {
            return 0;
        }

        final String[] splitText = text.split(",");
        if (splitText.length > 1) {
            return sum(splitText);
        }

        final int number = Integer.parseInt(text);
        return number;
    }

    private static int sum(final String[] splitText) {
        int sum = 0;
        for (final String text : splitText) {
            sum += Integer.parseInt(text);
        }
        return sum;
    }

    private static boolean isEmptyOrNull(final String text) {
        return text == null || text.isEmpty();
    }
}
