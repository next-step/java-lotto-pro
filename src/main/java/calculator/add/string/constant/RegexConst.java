package calculator.add.string.constant;

import java.util.regex.Pattern;

public class RegexConst {

    public static final String POSITIVE_INTEGER_TYPE_REGEX = "\\d+";
    public static final String DEFAULT_DELIMITERS = "[,:]";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private RegexConst() {
    }

}
