package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternSpliter implements Spliter {
    private final String inputValue;
    private static final String REGEXP = "//(.)\\n(.*)";

    public PatternSpliter(String inputValue) {
        this.inputValue = inputValue;
    }

    @Override
    public String[] split() {
        String[] split = new String[0];
        Matcher matcher = Pattern.compile(REGEXP).matcher(inputValue);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            split = matcher.group(2).split(delimiter);
        }
        return split;
    }

}
