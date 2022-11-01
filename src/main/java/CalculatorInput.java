import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorInput {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int CUSTOM_DELIMITER_GROUP = 1;
    private static final int TEXT_GROUP = 2;
    private String text;
    private final List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));

    public CalculatorInput(String text) {
        this.text = text;

        if (!isEmpty()) {
            parseCustomDelimiter(text);
        }
    }

    public boolean isEmpty() {
        return text == null || text.isEmpty();
    }

    public List<Integer> getNumbers() {
        String[] numbers = text.split(String.join("|", delimiters));
        return Arrays.stream(numbers)
            .map(Number::new)
            .map(Number::getNumber)
            .collect(Collectors.toList());
    }

    private void parseCustomDelimiter(String text) {
        Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(CUSTOM_DELIMITER_GROUP);
            delimiters.add(customDelimiter);
            this.text = m.group(TEXT_GROUP);
        }
    }
}
