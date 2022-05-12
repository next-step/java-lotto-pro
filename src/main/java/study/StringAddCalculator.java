package study;

<<<<<<< HEAD
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
=======
public class StringAddCalculator {

    private static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }
        return sumNumbers(convertStringArrayToIntArray(splitText(text)));
    }

    private static String[] splitText(String text) {
        return text.split(SEPARATOR);
    }

    private static int[] convertStringArrayToIntArray(String[] stringNumbers) {
        int[] numbers = new int[stringNumbers.length];
        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
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

    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
>>>>>>> 37e5d9a (feat: 빈 문자열 또는 null 값을 입력할 경우 0을 반환)
    }
}