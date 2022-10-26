package step2;

import java.util.ArrayList;
import java.util.List;

public class StringAddCalculator {
    static StringParser stringParser = new StringParser();

    public static Number splitAndSum(String text) {
        if (text == null) return new Number();
        if (text.isEmpty()) return new Number();
        List<Number> numbers = convertStringToNumbers(text);

        return sumCalculate(numbers);
    }

    private static List<Number> convertStringToNumbers(String text) {
        String[] numberTexts = stringParser.parseText(text);
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
