package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final String inputValue;

    public StringCalculator(String inputValue) {
        this.inputValue = inputValue;
    }

    public int result() {
        if (inputValue == null || inputValue.isEmpty()) {
            return 0;
        }

        if (inputValue.length() == 1) {
            return Integer.parseInt(inputValue);
        }

        Matcher matcher = Pattern.compile("//(.)\\n(.*)").matcher(inputValue);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            String[] split = matcher.group(2).split(delimiter);
            return sum(split);
        }

        if (inputValue.length() > 1) {
            String[] split = inputValue.split(",|:");
            return sum(split);
        }


        throw new RuntimeException();
    }

    private int sum(String[] split) {
        int result = 0;
        for (int index = 0; index < split.length; index++) {
            result += Integer.parseInt(split[index]);
        }
        return result;
    }

}
