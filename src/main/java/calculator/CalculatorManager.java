package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorManager {
    private static final String DEFAULT_DELIMITERS = ",:";
    private static final int MATCH_GROUP_DELIMITER = 1;
    private static final int MATCH_GROUP_NUMBER = 2;
    private static final String REGEX_FIND_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(REGEX_FIND_DELIMITER);

    private Delimiters delimiters;
    private NumbersText numbersText;
    private final Numbers numbers;

    public CalculatorManager(String text) {
        delimiters = new Delimiters(DEFAULT_DELIMITERS);
        numbersText = new NumbersText(text);
        parseString(text);
        numbers = new Numbers(getSplitNumbersText());
    }

    private void parseString(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            delimiters = new Delimiters(DEFAULT_DELIMITERS + matcher.group(MATCH_GROUP_DELIMITER));
            numbersText = new NumbersText(matcher.group(MATCH_GROUP_NUMBER));
        }
    }

    public String[] getSplitNumbersText() {
        return numbersText.splitNumbersText(delimiters);
    }

    public int getSum() {
        return numbers.getSum();
    }
}
