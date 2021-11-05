package calculator;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private Pattern pattern;
    private final String DEFAULT_SEPARATOR = ",|:";

    public StringAddCalculator() {
        pattern = Pattern.compile("//(.)\n(.*)");
    }

    public int calculate(String text) {
        if(Objects.isNull(text) || text.isEmpty()) return 0;
        String[] splitStrings = splitString(text);
        int[] numbers = stringsToNumbers(splitStrings);
        return sum(numbers);
    }

    private String[] splitString(String text) {
        String separator = getSeparator(text);
        if(separator.isEmpty()) {
            return splitString(text, DEFAULT_SEPARATOR);
        }
        return splitString(getOriginText(text), separator);
    }

    private String[] splitString(String text, String separator) {
        return text.split(separator);
    }

    private String getSeparator(String text) {
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }

    private String getOriginText(String text) {
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()) {
            return matcher.group(2);
        }
        return "";
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for(int number : numbers)
        {
            sum += number;
        }
        return sum;
    }

    private int[] stringsToNumbers(String[] splitStrings) {
        int[] numbers = new int[splitStrings.length];
        for(int i=0;i<splitStrings.length;i++)
        {
            numbers[i] = stringToNumber(splitStrings[i]);
            validateNegative(numbers[i]);
        }
        return numbers;
    }

    private int stringToNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNegative(int number) {
        if(number < 0) throw new IllegalArgumentException();
    }
}
