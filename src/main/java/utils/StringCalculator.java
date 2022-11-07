package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int EMPTY_INPUT_REPLACE = 0;
    private static final String[] BASIC_DELIMITER = {",", ":"};
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int STRING_VALUE_INDEX = 2;

    public static int splitAndSum(String inputText) {
        if (checkInputEmpty(inputText)) {
            return EMPTY_INPUT_REPLACE;
        }
        String[] splitResult = splitInputText(inputText);
        int[] convertResult = convertStringToInt(splitResult);
        for (int number : convertResult) {
            checkNumber(number);
        }
        return addNumbers(convertResult);
    }

    private static boolean checkInputEmpty(String inputText) {
        return inputText == null || inputText.isEmpty();
    }

    private static String[] splitInputText(String inputText) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_DELIMITER));
        customDelimiterHandle(inputText, delimiters);
        String splitRegExp = getSplitRegExp(delimiters);
        return inputText.split(splitRegExp);
    }

    private static String getSplitRegExp(List<String> delimiters) {
        StringJoiner result = new StringJoiner("|");
        for (String delimiter : delimiters) {
            result.add(delimiter);
        }
        return result.toString();
    }

    private static void customDelimiterHandle(String inputText, List<String> delimiters) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(inputText);
        if (m.find()) {
            inputText = removeCustomDelimiterPattern(m);
            addDelimiter(inputText, delimiters, m.group(DELIMITER_INDEX));
        }
    }

    private static String removeCustomDelimiterPattern(Matcher m) {
        return m.group(STRING_VALUE_INDEX);
    }

    private static void addDelimiter(String inputText, List<String> delimiters, String customDelimiter) {
        //커스텀 구분자가 있는 경우 커스텀 구분자를 구분자로 세팅 (기본 구분자 제거)
        //커스탐 구분자가 문자열에 없는 경우 기본 구분자 유지
        if (inputText.contains(customDelimiter)) {
            delimiters.clear();
            delimiters.add(customDelimiter);
        }
    }

    private static int[] convertStringToInt(String[] splitResult) {
        int[] convertResult = new int[splitResult.length];
        for (int i = 0; i < splitResult.length; i++) {
            convertResult[i] = parseInt(splitResult[i]);
        }
        return convertResult;
    }

    private static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new RuntimeException("구분자 외에는 숫자만 입력해주세요");
        }
    }

    private static void checkNumber(int number) {
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다");
        }
    }

    private static int addNumbers(int[] convertResult) {
        int result = 0;
        for (int number : convertResult) {
            result += number;
        }
        return result;
    }
}
