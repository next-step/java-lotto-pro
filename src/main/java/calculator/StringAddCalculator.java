package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CUSTOM_EXPRESSION = "//(.)\n(.*)";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_EXPRESSION);

    private StringAddCalculator() {
    }

    public static int splitAndSum(String text) {
        if (hasNotText(text))
            return 0;
        Matcher matcher = CUSTOM_PATTERN.matcher(text);
        if (matcher.find()) {
            return calculateSum(makeCustomSplitDto(matcher));
        }
        return calculateSum(SplitDto.of(text));
    }

    private static boolean hasNotText(String text) {
        if (text == null) {
            return true;
        }
        if (text.length() == 0) {
            return true;
        }
        return doesNotContainText(text);
    }

    private static boolean doesNotContainText(String text) {
        String trimmedString = text.trim();
        return isEmptyString(trimmedString);
    }

    private static boolean isEmptyString(String text) {
        return "".equals(text);
    }

    private static int calculateSum(SplitDto dto) {
        String[] strings = dto.split();
        int sum = 0;
        for (String string : strings) {
            sum += getNumberValue(string);
        }
        return sum;
    }

    private static int getNumberValue(String string) {
        int value = parseInt(string);
        if (value < 0) {
            throw new RuntimeException("음수 값을 입력할 수 없습니다.");
        }
        return value;
    }

    private static int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("입력이 올바르지 않습니다.");
        }
    }

    private static SplitDto makeCustomSplitDto(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String extractedText = matcher.group(2);
        return SplitDto.of(extractedText, customDelimiter);
    }
}
