package study;

public class StringAddCalculator {

    public static int splitAndSum(String numberWords) {
        if (numberWords == null || numberWords.isEmpty()) {
            return 0;
        }
        if (numberWords.length() == 1) {
            return wordToNumber(numberWords);
        }
        return Integer.MAX_VALUE;
    }

    private static int wordToNumber(String numberWords) {
        if (numberWords.matches("\\p{Digit}")) {
            return Integer.parseInt(numberWords);
        }
        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
    }
}
