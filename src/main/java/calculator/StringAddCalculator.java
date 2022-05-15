package calculator;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        Numbers numbers = Numbers.of(SplitGenerator.splitWithDelimiter(text));
        return calculateSum(numbers);
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int calculateSum(Numbers numbers) {
        return numbers.getTotalSum();
    }
}
