public class StringAddCalculator {

    public static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    public static final String COMMA = ",";
    public static final String COLON = ":";
    public static final int NUMBER_ZERO = 0;

    public static int splitAndSum(String inputText) {
        if (inputText == null || inputText.isEmpty()) return NUMBER_ZERO;

        if (inputText.matches(CUSTOM_DELIMITER_PATTERN)) {
            String[] numbers = SplitInputText.splitCustomDelimiter(inputText);
            return sumStringNumberArray(numbers);
        }

        if (inputText.contains(COMMA) || inputText.contains(COLON)) {
            String[] numbers = SplitInputText.splitCommaOrColon(inputText);
            return sumStringNumberArray(numbers);
        }

        return Integer.parseInt(inputText);
    }

    private static int sumStringNumberArray(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            ValidationUtils.checkValidateNumber(number);
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
