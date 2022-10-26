package step2;

public class StringAddCalculator {
    static StringParser stringParser = new StringParser();

    public static Number splitAndSum(String text) {
        if (text == null) return new Number();
        if (text.isEmpty()) return new Number();
        Numbers numbers = convertStringToNumbers(text);

        return sumCalculate(numbers);
    }

    private static Numbers convertStringToNumbers(String text) {
        String[] numberTexts = stringParser.parseText(text);
        return new Numbers(numberTexts);
    }

    private static Number sumCalculate(Numbers numbers) {
        Number result = new Number();

        for (Number num : numbers.numbers()) {
            result.plus(num);
        }

        return result;
    }
}
