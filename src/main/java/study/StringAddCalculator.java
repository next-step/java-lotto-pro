package study;

public class StringAddCalculator {

    public static final String INVALID_CUSTOM_PATTERN_ERR_MSG = "지정되지 않은 구분자 사용";
    public static final String INVALID_INPUT_ERR_MSG = "유효하지 않은 값 입력(양수만 입력가능)";

    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }

        Text createdText = TextFactory.createText(text);
        Numbers.makeNumberGroup(createdText.splitWithDelimeter());

        return Numbers.sumAllNumbers();
    }

    private static boolean isNullOrEmpty(final String text) {
        return text == null || text.equals("");
    }
}
