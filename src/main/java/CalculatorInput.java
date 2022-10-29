import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorInput {
    private final List<String> delimiters = new ArrayList<>(Arrays.asList(",", ":"));
    private String text;

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
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            delimiters.add(customDelimiter);
            this.text = m.group(2);
        }
    }
}
