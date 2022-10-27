package study.step2.domain.textspliterator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterSpliterator implements TextSpliterator {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    @Override
    public String[] split(String text) {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(text);
        if(isInseparable(matcher)) {
            return null;
        }

        String customDelimiter = matcher.group(1);
        String group = matcher.group(2);
        return group.split("[" + customDelimiter + "]");
    }

    private boolean isInseparable(Matcher matcher) {
        return !matcher.find();
    }
}
