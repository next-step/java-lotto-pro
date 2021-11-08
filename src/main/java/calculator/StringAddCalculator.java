package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 *  피드백 내용
 *      1) else 문을 사용하지 않는다. => else if로 작성하지 말고 if 조건에 해당하는 경우 리턴하자.
 *      2) 매직넘버을 하지 않는다 => 의미가 불분명한 매직 넘버는 상수로 선언한다.
 *      3) 주석이 없어도 잘 읽힐 수 있는 코드를 작성한다. => 함수명으로 동작의도를 드러내도록 한다.
 */

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
    private static final int NULL_OR_EMPTY = 0; //NULL 또는 공백의 경우 리턴 처리값

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) return NULL_OR_EMPTY;
        if (text.length() == 1) return parseInt(text);
        return splitText(text);
    }

    //0~9 숫자가 아닐 경우 예외를 발생할 수 있습니다.
    private static int parseInt(String text) {
        if (!text.matches(REG_EXP_NUMBER)) throw new RuntimeException("0~9 사이의 숫자만 입력이 가능합니다.");
        return Integer.parseInt(text);
    }

    private static int splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return sum(tokens);
        }
        String[] tokens = text.split(SPLIT_BASIC_SEPARATOR);
        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens).map(token -> parseInt(token)).reduce(0, Integer::sum);
    }

}