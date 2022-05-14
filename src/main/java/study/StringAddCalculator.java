package study;

<<<<<<< HEAD
<<<<<<< HEAD
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
        for (int number : numbers) {
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
=======
import java.util.regex.Matcher;
import java.util.regex.Pattern;

>>>>>>> 9111970 (feat: “//”와 “\n” 문자 사이에 커스텀 구분자를 지정 및 리팩토링)
public class StringAddCalculator {

    private static final int DELIMITER_INDEX = 1;
    private static final int TEXT_INDEX = 2;
=======
import static study.StringUtil.convertStringArrayToIntArray;

>>>>>>> 4b62bd1 (fix: 클래스 분리 ( 공용역할을 하는 StirngUtil, 인풋처리하는 CalculatorInputUtil ))

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (StringUtil.isNullOrEmpty(text)) {
            return 0;
        }
        if (CalculatorInputUtil.hasCustomDelimiter(text)) {
            return sumNumbers(convertStringArrayToIntArray(
                CalculatorInputUtil.splitTextWithCustomDelimiter(text)));
        }
        return sumNumbers(convertStringArrayToIntArray(StringUtil.splitText(text, CalculatorInputUtil.DELIMITER)));
    }

    public static void checkNegativeNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private static int sumNumbers(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
<<<<<<< HEAD

<<<<<<< HEAD
    private static boolean isNullOrEmpty(String text) {
        if (text == null || text.isEmpty()) {
            return true;
        }
        return false;
>>>>>>> 37e5d9a (feat: 빈 문자열 또는 null 값을 입력할 경우 0을 반환)
    }
=======
>>>>>>> 9111970 (feat: “//”와 “\n” 문자 사이에 커스텀 구분자를 지정 및 리팩토링)
=======
>>>>>>> 4b62bd1 (fix: 클래스 분리 ( 공용역할을 하는 StirngUtil, 인풋처리하는 CalculatorInputUtil ))
}
