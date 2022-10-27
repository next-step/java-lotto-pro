package calculator.domain.target.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements CalculatorSplitter {

    private static final int CAPTURE_SEPARATOR = 1;
    private static final int CAPTURE_TARGET = 2;
    private static Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private CalculatorSplitter splitter;

    public CustomSplitter(CalculatorSplitter splitter) {
        this.splitter = splitter;
    }

    @Override
    public String[] split(String target) {
        Matcher m = CUSTOM_PATTERN.matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(CAPTURE_SEPARATOR);
            return m.group(CAPTURE_TARGET).split(customDelimiter);
        }
        return splitter.split(target);
    }
}
