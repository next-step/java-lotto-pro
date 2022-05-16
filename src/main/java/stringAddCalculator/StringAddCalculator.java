package stringAddCalculator;

import utils.CustomStringUtils;

import java.util.List;

public class StringAddCalculator {
    private static final int DEFAULT_INT = 0;

    public static int splitAndSum(String text) {
        if (CustomStringUtils.isNullOrEmpty(text)) {
            return DEFAULT_INT;
        }
        List<String> splitText = CustomStringUtils.splitString(text);
        int sum = calculateStringSum(splitText);
        return sum;
    }

    private static int calculateStringSum(List<String> splitText) {
        int result = 0;
        for (String str : splitText) {
            result += CustomStringUtils.parseStringToPositiveInteger(str);
        }
        return result;
    }
}
