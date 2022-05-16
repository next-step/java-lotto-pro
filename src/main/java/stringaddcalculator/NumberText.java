package stringaddcalculator;

public class NumberText {

    public static final NumberText EMPTY = new NumberText(PositiveInteger.ZERO);
    private static final String NUMERIC_PATTERN = "\\d";
    private final PositiveInteger number;

    private NumberText(final PositiveInteger number) {
        this.number = number;
    }

    public static NumberText parse(final String text) {
        validateInputText(text);
        return new NumberText(PositiveInteger.valueOf(text));
    }

    public NumberText add(final NumberText numberText) {
        return new NumberText(number.add(numberText.getNumber()));
    }

    public PositiveInteger getNumber() {
        return number;
    }

    private static void validateInputText(final String text) {
        if (isNullOrEmpty(text)) {
            throw new IllegalArgumentException("");
        }

        if (!text.matches(NUMERIC_PATTERN)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.isEmpty();
    }
}
