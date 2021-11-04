package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorManager {
    private static final int MATCH_GROUP_DELIMITER = 1;
    private static final int MATCH_GROUP_NUMBER = 2;
    private static final String REGEX_FIND_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(REGEX_FIND_DELIMITER);

    private Delimiters delimiters;
    private NumbersText numbersText;
    private final Numbers numbers;

    public CalculatorManager(String text) {
        parseString(text);
        numbers = new Numbers(getNumbersText());
    }

    private void parseString(String text) {
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            delimiters = new Delimiters(matcher.group(MATCH_GROUP_DELIMITER));
            numbersText = new NumbersText(matcher.group(MATCH_GROUP_NUMBER));
            return;
        }

        delimiters = new Delimiters();
        numbersText = new NumbersText(text);
    }

    public String[] getNumbersText() {
        return numbersText.splitNumbersText(delimiters);
    }

    public int getSum() {
        return numbers.getSum();
    }
}
