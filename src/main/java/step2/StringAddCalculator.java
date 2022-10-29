package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String patternRegex = "//(.)\n(.*)";
    private static final String delimiterExceptionRegex = "[!@#$%^&*(),.?\":{}|<>]";
    private static final String basicSplitRegex = ",|:";
    private static final String negativeExceptionMessage = "negative number included Exception";
    private static int sum;
    private static String delimiter;
    private static String exceptDelimiterString;

    public StringAddCalculator() {
        this.sum = 0;
        this.delimiter = basicSplitRegex;
        this.exceptDelimiterString = "";
    }

    public static int splitAndSum(String target) {
        if (isNullOrEmpty(target)) {
            return sum;
        }
        String[] numbers = doSplitAndSum(target);
        sumSplitedNumbers(numbers);
        return sum;
    }

    private static void sumSplitedNumbers(String[] numbers) {
        for (String i : numbers) {
            isUnderZeroNumber(i);
            sum += Integer.parseInt(i);
        }
    }

    private static String[] doSplitAndSum(String target) {
        if (!isFind(patternRegex, target)) {
            return target.split(basicSplitRegex);
        }
        return getCustomDelimiterNumbers(patternRegex, target);
    }

    private static String[] getCustomDelimiterNumbers(String regex, String target) {
        Matcher m = getMatcher(regex, target);
        if (m.find()) {
            delimiter = m.group(1);
            exceptDelimiterString = m.group(2);
        }

        if (isFind(delimiterExceptionRegex, target)) {
            setCustomDelimiter();
        }

        return exceptDelimiterString.split(delimiter);
    }

    private static void isUnderZeroNumber(String number) {
        if (Integer.parseInt(number) < 0) {
            throw new RuntimeException(negativeExceptionMessage);
        }
    }

    private static boolean isFind(String regex, String target) {
        return getMatcher(regex, target).find();
    }

    private static Matcher getMatcher(String regex, String target) {
        return patternCompile(regex).matcher(target);
    }

    private static Pattern patternCompile(String regex) {
        return Pattern.compile(regex);
    }

    private static boolean isNullOrEmpty(String target) {
        return target == null || target.isEmpty();
    }

    private static void setCustomDelimiter() {
        delimiter = "[" + delimiter + "]";
    }


}
