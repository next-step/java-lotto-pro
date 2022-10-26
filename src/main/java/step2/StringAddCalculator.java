package step2;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;

    public static int splitAndSum(String text) {
        if(isEmptyOrNull(text)) {
            return DEFAULT_VALUE;
        }
        int[] numbers = StringParser.parseToIntArray(text);
        return Sum.from(numbers);
    }

    private static boolean isEmptyOrNull(String text) {
        return text == null || text.isEmpty();
    }



}
