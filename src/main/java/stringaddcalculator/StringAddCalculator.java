package stringaddcalculator;

public class StringAddCalculator {

    public static int splitAndSum(final String text) {
        NaturalNumbers parsedNumbersFromText = NaturalNumberParser.parse(text);
        return parsedNumbersFromText.sum();
    }
}
