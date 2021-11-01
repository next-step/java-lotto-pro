package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;

    public static int splitAndSum(String inputNumberText) {
        if (isEmpty(inputNumberText)) {
            return 0;
        }
        return calculateNumber(inputNumberText);
    }

    private static int calculateNumber(String inputNumberText) {
        if (isCustomDelimeter(inputNumberText)) {
            return addNumberByCustomDelimiter(inputNumberText);
        }

        String[] numbers = inputNumberText.split(",|:");
        return addNumber(numbers);

    }

    private static int addNumberByCustomDelimiter(String inputNumberText) {
        // java.util.regex 패키지의 Matcher, Pattern import
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputNumberText);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return addNumber(tokens);
        }
        throw new RuntimeException("잘못된 문자를 입력하였습니다");
    }

    private static boolean isCustomDelimeter(String inputNumberText) {
        return inputNumberText.charAt(ZERO) == '/';
    }

    private static int addNumber(String[] numbers) {
        isWrongNumber(numbers);
        int sum = 0;
        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private static void isWrongNumber(String[] numbers) {
        String regularExpression = "^[0-9]*$";
        for (String number : numbers) {
            if (!Pattern.matches(regularExpression, number)) {
                throw new RuntimeException("잘못된 문자를 입력하였습니다.");
            }
        }
    }

    private static boolean isEmpty(String inputNumberText) {
        return inputNumberText == null || inputNumberText.isEmpty();
    }
}
