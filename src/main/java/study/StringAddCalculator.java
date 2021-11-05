package study;

public class StringAddCalculator {

    public static final String INVALID_CUSTOM_PATTERN_ERR_MSG = "지정되지 않은 구분자 사용";
    public static final String INVALID_INPUT_ERR_MSG = "유효하지 않은 값 입력(양수만 입력가능)";

    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }

        Text createdText = TextFactory.createText(text);

        return sumAllNumbers(splitText(createdText));
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.equals("");
    }

    private static String[] splitText(final Text text) {
        return text.splitWithDelimeter();
    }

    private static int sumAllNumbers(final String[] numbers) {
        int result = 0;
        for(String number : numbers) {
            result += parseNumber(number);
        }
        return result;
    }

    private static int parseNumber(String number) {
        int result = Integer.parseInt(number);
        validateNegativeNumber(result);
        return result;
    }

    private static void validateNegativeNumber(int number) {
        if(number < 0) {
            throw new RuntimeException(INVALID_INPUT_ERR_MSG);
        }
    }
}
