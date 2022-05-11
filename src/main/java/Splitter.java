import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
    private static final String DEFAULT_DELIMITER = "[,|:]";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int GROUP_INDEX_ONE = 1;
    private static final int GROUP_INDEX_TWO = 2;
    private final String input;

    public Splitter(String input) {
        this.input = input;
    }

    public static Numbers addNumbers(String[] fractions) {
        List<Number> numberList = new ArrayList<>();
        for (String numberString : fractions) {
            int number = Integer.parseInt(numberString);
            numberList.add(new Number(number));
        }
        return new Numbers(numberList);
    }

    public static String[] getFractionByDelimiter(String input) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(GROUP_INDEX_ONE);
            return m.group(GROUP_INDEX_TWO).split(customDelimiter);
        }

        return input.split(DEFAULT_DELIMITER);
    }

}
