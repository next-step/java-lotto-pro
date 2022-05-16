package study;

import static study.StringUtil.convertStringArrayToIntArray;


public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (StringUtil.isNullOrEmpty(text)) {
            return 0;
        }
        return sumNumbers(checkNegativeNumberOrThrow(
            convertStringArrayToIntArray(CalculatorInputUtil.splitTextWithDelimiter(text))));
    }

    private static int[] checkNegativeNumberOrThrow(int[] numbers) {
<<<<<<< HEAD
        for (int number : numbers) {
=======
    for (int number : numbers) {
>>>>>>> a3c1c43 (docs: 기능 목록 정리)

            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
        }
        return numbers;
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}