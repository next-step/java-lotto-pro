package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String patternRegex = "//(.)\n(.*)";
    private static String delimiterExceptionRegex = "[!@#$%^&*(),.?\":{}|<>]";
    private static String basicSplitRegex = ",|:";
    private static int sum;
    private static String delimiter = "";

    public static int splitAndSum(String target) {
        init();
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
        String exceptDelimiterString = "";
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
            throw new RuntimeException("negative Exception");
        }
    }

    private static void init() {
        sum = 0;
        delimiter = basicSplitRegex;
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
