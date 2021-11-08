package stringaddcalculator;

import java.util.stream.Collectors;

public class NaturalNumberParser {

    private static final NaturalNumbers EMPTY_NUMBERS = new NaturalNumbers();

    public static NaturalNumbers parse(final String text) {
        SplitTexts texts = StringSplitter.split(text);

        if (texts.isEmpty()) {
            return EMPTY_NUMBERS;
        }

        return new NaturalNumbers(
            texts.getValues()
                .stream()
                .map(NaturalNumber::new)
                .collect(Collectors.toList())
        );
    }
}
