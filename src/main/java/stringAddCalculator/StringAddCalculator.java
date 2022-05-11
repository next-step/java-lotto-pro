package stringAddCalculator;

import utils.CustomStringUtils;

public class StringAddCalculator {
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] splitText = CustomStringUtils.splitString(text);
        int sum = calculateStringSum(splitText);
        return sum;
    }

    private static int calculateStringSum(String[] splitText) {
        int result = 0;
        for (String str : splitText) {
            result += CustomStringUtils.parseStringToPositiveInteger(str);
        }
        return result;
    }
}
