package calculator;

import calculator.constant.Delimiter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Spliter {
    private static final Pattern CUSTOM_PATTERN = Pattern.compile(Delimiter.CUSTOM_DELIMITER.getDelimiter());

    Numbers split(String text) {
        Matcher m = CUSTOM_PATTERN.matcher(text);
        if (m.find()) {
            return new Numbers(m.group(2).split(m.group(1)));
        }
        return new Numbers(text.split(Delimiter.BASIC_DELIMITER.getDelimiter()));
    }
}
