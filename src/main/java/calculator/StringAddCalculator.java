package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    /**
     * 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.(예 : “1”)
     * 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.(예 : “1,2”)
     * 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (예 : “1,2:3” => 6)
     * 빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.(예 : “” => 0, null => 0)
     *
     * @param text
     * @return int
     */
    public static int splitAndSum(String text) {
        if (null == text || text.isEmpty()) {
            return 0;
        }

        return Arrays.stream(splitText(text)).mapToInt(i -> getPositiveInteger(i)).sum();
    }

    public static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }

        return text.split(",|:");
    }

    public static int getPositiveInteger(String input) {
        int number = Integer.parseInt(input);

        if (number < 0) {
            throw new RuntimeException();
        }

        return number;
    }
}
