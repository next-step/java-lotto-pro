package study;

public class StringAddCalculator {

    public static int splitAndSum(String numberWords) {
        int sum = 0;
        if (numberWords == null || numberWords.isEmpty()) {
            return sum;
        }
        String[] splitNumbers = numberWords.split(",");
        sum = sumNumbers(sum, splitNumbers);
        return sum;
    }

    private static int sumNumbers(int sum, String[] splitNumbers) {
        for (String number : splitNumbers) {
            sum += wordToNumber(number);
        }
        return sum;
    }

    private static int wordToNumber(String number) {
        if (number.matches("\\p{Digit}")) {
            return Integer.parseInt(number);
        }
        throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
    }
}
