package calculator.domain.target.splitter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomSplitter implements CalculatorSplitter {

    private static Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private CalculatorSplitter splitter;

    public CustomSplitter(CalculatorSplitter splitter) {
        this.splitter = splitter;
    }

    @Override
    public String[] split(String target) {
        Matcher m = CUSTOM_PATTERN.matcher(target);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return splitter.split(target);
    }
}
