package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String EMPTY_INPUT_REPLACE = "0";
    private static final String[] BASIC_DELIMITER = {",", ":"};
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String inputText) {
        inputText = emptyInputHandle(inputText);
        String[] splitResult = splitInputText(inputText);
        int[] convertResult = convertIntoInt(splitResult);
        for (int number : convertResult) {
            checkNumber(number);
        }
        return addNumbers(convertResult);
    }

    private static String emptyInputHandle(String inputText) {
        if (inputText == null || inputText.isEmpty()) {
            inputText = EMPTY_INPUT_REPLACE;
        }
        return inputText;
    }

    private static String[] splitInputText(String inputText) {
        List<String> delimiters = new ArrayList<>(Arrays.asList(BASIC_DELIMITER));
        inputText = getStandardForm(inputText, delimiters);
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

    private static String getStandardForm(String inputText, List<String> delimiters) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(inputText);
        if (m.find()) {
            delimiters.clear(); // 지정한 구분자로만 분리하고자 할 때 (기본 구분자도 구분자로 인식하려면 주석처리)
            delimiters.add(m.group(1));
            inputText = m.group(2);
        }
        return inputText;
    }

    private static int[] convertIntoInt(String[] splitResult) {
        try {
            int[] convertResult = new int[splitResult.length];
            for (int i = 0; i < splitResult.length; i++) {
                convertResult[i] = Integer.parseInt(splitResult[i]);
            }
            return convertResult;
        } catch (Exception e) {
            throw new RuntimeException("구분자 외에는 숫자만 입력해주세요");
        }
    }

    private static void checkNumber(int number) {
        if (number < 0) {
            throw new RuntimeException();
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
