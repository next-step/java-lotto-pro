package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String BASE_DELIMITER = ",|:";
    private static final Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public static Number splitAndSum(String text) {
        if (text == null) return new Number();
        if (text.isEmpty()) return new Number();
        List<Number> numbers = convertStringToNumbers(text);

        return sumCalculate(numbers);
    }

    static String[] parseText(String text) {
        Matcher m = pattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(BASE_DELIMITER);
    }

    private static List<Number> convertStringToNumbers(String text) {
        String[] numberTexts = parseText(text);
        List<Number> result = new ArrayList<>();
        for (String numberText : numberTexts) {
            result.add(new Number(numberText));
        }
        return result;
    }

    private static Number sumCalculate(List<Number> numbers) {
        Number result = new Number();

        for (Number num : numbers) {
            result.plus(num);
        }

        return result;
    }
}
