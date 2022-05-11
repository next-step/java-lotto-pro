package stringaddcalculator;

public class StringAddCalculator {

    private static final int EMPTY_SUMMARY = 0;

    public static int sumNumberTexts(final String text) {
        if (isNullOrEmpty(text)) {
            return EMPTY_SUMMARY;
        }

        return NumberTextsString.valueOf(text)
                .summary();
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.isEmpty();
    }

}
