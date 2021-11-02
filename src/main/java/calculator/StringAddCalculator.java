package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * packageName : calculator
 * fileName : StringAddCalculator
 * author : haedoang
 * date : 2021-11-02
 * description :
 */
public class StringAddCalculator {
    private static final String SPLIT_BASIC_SEPARATOR = ",|:"; //기본 문자열 구분자
    private static final String REG_EXP_NUMBER = "[0-9]"; //숫자 정규식

    /**
     *
     * @param text
     * @return
     * description 문자가 0 또는 빈 값일 경우 0으로 반환한다.
     *             문자 입력의 길이가 1인 경우 숫자의 경우 숫자를 리턴하고, 아닌 경우 예외를 발생시킨다.
     *             그 외의 경우 문자열 덧셈 계산을 한다.
     */
    public static int splitAndSum(String text) {
        if(text == null) return 0;
        else if(text.isEmpty()) return 0;
        else if (text.length() == 1) return parseInt(text);
        return splitText(text);
    }

    /**
     *
     * @param text
     * description 문자를 숫자로 형변환한다. 음수이거나 문자인 경우 RuntimeException 예외를 발생시킨다.
     */
    private static int parseInt(String text) {
        if(!text.matches(REG_EXP_NUMBER)) throw new RuntimeException("0~9 사이의 숫자만 입력이 가능합니다.");
        return Integer.parseInt(text);
    }

    /**
     *
     * @param text
     * description 커스텀 구분자 유무에 따라 문자열 변환을 분기처리한다.
     */
    private static int splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        //custom separator
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        //basic separator  1) , 2) :
        String[] tokens = text.split(SPLIT_BASIC_SEPARATOR);
        return sum(tokens);
    }

    /**
     *
     * @param tokens
     * description split 된 문자 배열을 숫자로 형변환 후 더한 값을 반환한다.
     */
    private static int sum(String[] tokens) {
        return Arrays.stream(tokens).map(token -> parseInt(token)).reduce(0, Integer::sum);
    }

}
