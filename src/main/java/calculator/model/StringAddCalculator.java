package calculator.model;

import exception.IllegalArgument;

import java.util.Arrays;

public class StringAddCalculator {

    public static int splitAndSum(String text) throws RuntimeException{
        if (isEmpty(text)) {
            return 0;
        }

        StringPattern pattern = StringAddCalculator.determineStringPattern(text);
        Separator separator = new Separator(pattern, text);

        return StringAddCalculator.sumNumberList(separator.separate());
    }

    public static boolean isEmpty(String text) {
        return (text == null) || text.isEmpty();
    }

    public static StringPattern determineStringPattern(String text) {
        if (text.matches(StringPatternRegex.FIXEDPATTERN)) {
            return StringPattern.FIXED;
        }

        if (text.matches(StringPatternRegex.CUSTOMPATTERN)) {
            return StringPattern.CUSTOM;
        }

        return StringPattern.NOTHING;
    }

    public static int sumNumberList(String[] list) throws RuntimeException {
        try{
            return Arrays.stream(list).mapToInt(Integer::parseInt).sum();
        } catch(NumberFormatException e) {
            throw IllegalArgument.NEGATIVE_OR_NOT_NUMBER;
        }

    }

}
