package lotto.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static lotto.constants.CalculatorConstants.*;

public class StringAddCalculator {

    private final static Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public void stringCalculator(String inputString) {
        int sum = getNumberList(inputString);
    }

    public int getNumberList(String inputString) {
        String args = getCheckInputString(inputString);
        List<Integer> list = splitInputString(args);
        return list
                .stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public String getCheckInputString(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return "0";
        }
        return inputString;
    }

    private List<Integer> splitInputString(String inputString) {
        List<String> result = getSplitList(inputString);
        validateNumberFormat(result);
        return result
                .stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private List<String> getSplitList(String inputString) {
        Matcher matcher = pattern.matcher(inputString);
        if (matcher.find()) {
            return getCustomRegexSplitList(matcher);
        }
        return getDefaultRegexSlitList(inputString);
    }

    private List<String> getCustomRegexSplitList(Matcher matcher) {
        String customRegex = matcher.group(1);
        String remainderString = matcher.group(2);
        return Arrays
                .asList(remainderString.split(customRegex));
    }

    private List<String> getDefaultRegexSlitList(String matcher) {
        return Arrays
                .asList(matcher.split(DEFAULT_SPLIT_REGEX));
    }

    private void validateNumberFormat(List<String> strings) {
        String joinString = String.join("", strings);
        if (!isNumber(joinString)) {
            System.out.println("[ERROR] 잘못된 입력 값입니다.");
            throw new IllegalArgumentException("[ERROR] 잘못된 입력 값입니다.");
        }
    }

    private boolean isNumber(String checkValue) {
        return checkValue.matches("^[0-9]+$");
    }

}
