package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final String CUSTOM_EXPRESSION = "//(.)\n(.*)";
    public static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_EXPRESSION);

    public static int splitAndSum(String text) {
        if (!hasText(text))
            return 0;
        if (hasCustomDelimiter(text)) {
            return calculateSum(makeCustomSplitDto(text));
        }
        return calculateSum(SplitDto.of(text));
    }

    private static boolean hasText(CharSequence text) {
        if (text == null)
            return false;
        if (text.length() == 0)
            return false;
        return containsText(text);
    }

    private static boolean containsText(CharSequence text) {
        int length = text.length();
        boolean hasText = false;
        for (int i = 0; i < length; i++) {
            hasText = isNotWhiteSpace(text.charAt(i));
        }
        return hasText;
    }

    private static boolean isNotWhiteSpace(char c) {
        return !Character.isWhitespace(c);
    }

    private static SplitDto makeCustomSplitDto(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String extractedText = m.group(2);
            return SplitDto.of(extractedText, customDelimiter);
        }
        throw new RuntimeException();
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

    private static boolean hasCustomDelimiter(String text) {
        return Pattern.matches(CUSTOM_EXPRESSION, text);
    }

    static class SplitDto {
        private String text;
        private String delimiter;

        public static SplitDto of(String text, String delimiter) {
            SplitDto dto = new SplitDto();
            dto.text = text;
            dto.delimiter = delimiter;
            return dto;
        }

        public static SplitDto of(String text) {
            SplitDto dto = new SplitDto();
            dto.text = text;
            dto.delimiter = DEFAULT_DELIMITER;
            return dto;
        }

        public String[] split() {
            return text.split(delimiter);
        }
    }

}
