package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {

    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    List<ZeroOrPositiveNumber> numberList;

    public Numbers() {
        this.numberList = new ArrayList<>();
    }

    public Numbers(String input) {
        this();

        if (!hasDefaultDelimiter(input) && !hasCustomDelimiter(input)) {
            this.createOneNumber(input);
            return ;
        }

        if (hasDefaultDelimiter(input) || hasCustomDelimiter(input)) {
            this.createNumbersWithDelimiter(input);
            return ;
        }

        throw new RuntimeException("Invalid input.");
    }

    public int sum() {
        int answer = 0;
        for (ZeroOrPositiveNumber number : numberList) {
            answer += number.getNumber();
        }
        return answer;
    }

    private void createNumbersWithDelimiter(String input) {
        if (hasDefaultDelimiter(input)) {
            this.addNumbers(input.split(",|:"));
            return ;
        }

        Matcher m = CUSTOM_DELIMITER.matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            this.addNumbers(m.group(2).split(customDelimiter));
        }
    }

    private void addNumbers(String[] tokens) {
        for (String token : tokens) {
            this.numberList.add(new ZeroOrPositiveNumber(token));
        }
    }

    private void createOneNumber(String input) {
        if (input == null || input.trim().isEmpty()) {
            this.numberList.add(new ZeroOrPositiveNumber(0));
            return ;
        }

        this.numberList.add(new ZeroOrPositiveNumber(input));
    }

    private boolean hasDefaultDelimiter(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return input.contains(",") || input.contains(":");
    }

    private boolean hasCustomDelimiter(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }

        return CUSTOM_DELIMITER.matcher(input).matches();
    }
}
