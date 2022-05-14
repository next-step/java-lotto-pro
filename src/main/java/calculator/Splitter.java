package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String FIND_NEW_DELIMITER_REGEX = "//(.)\n(.*)";

    private String delimiter = ",|:";
    private final String target;

    public Splitter(String input) {
        this.target = checkValidation(input);
    }

    public String[] getSplitResult() {
        return this.target.split(this.delimiter);
    }

    private void convertRegex(String regex) {
        this.delimiter = regex;
    }

    private String checkValidation(String input) {
        if (input == null) return "0";

        input = input.replace(" ", "");
        if (input.isEmpty()) return "0";

        Matcher m = Pattern.compile(FIND_NEW_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            convertRegex(m.group(1));
            return m.group(2);
        }

        return input;
    }
}
