package stringAddCalculator;

import utils.CustomStringUtils;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String[] splitInput = CustomStringUtils.splitString(input);
        int result = calculateStringSum(splitInput);
        return result;
    }

    private static int calculateStringSum(String[] strs) {
        int result = 0;
        for (String str : strs) {
            result += CustomStringUtils.parseStringToPositiveInteger(str);
        }
        return result;
    }
}
