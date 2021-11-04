package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String inputValue;
    private final StringValidation stringValidation;

    public StringCalculator(String inputValue) {
        this.inputValue = inputValue;
        stringValidation = new StringValidation(inputValue);
    }

    public int result() {
        try {
            stringValidation.isNullOrEmptyThrow();

        } catch (IllegalArgumentException e) {
            return 0;
        }

        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(inputValue);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] split = matcher.group(2).split(delimiter);
            return sum(split);
        }
        return sum(split(",|:"));
    }

    private String[] split(String delimiter) {
        return inputValue.split(delimiter);
    }

    private int sum(String[] split) {
        int result = 0;
        for (int index = 0; index < split.length; index++) {
            result += Integer.parseInt(split[index]);
        }
        return result;
    }

}
