package calculator.domain;

import calculator.utils.StringUtils;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if(isNullOrEmpty(text)) {
            return 0;
        }
        String[] textNumbers = StringUtils.split(text);
        PositiveNumbers positiveNumbers = new PositiveNumbers(textNumbers);
        return positiveNumbers.sumAll();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

}
