package stringaddcalculator;

import static java.util.Arrays.asList;
import static java.util.regex.Pattern.compile;

import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

public class NumberTextsString {

    private static final String DEFAULT_DELIMITER = ",|:";

    private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
    private List<NumberText> numberTexts;

    private NumberTextsString(final List<NumberText> numberTexts) {
        this.numberTexts = numberTexts;
    }

    public static NumberTextsString valueOf(final String texts) {
        return new NumberTextsString(convertNumberText(splitTexts(texts)));
    }

    public int summary() {
        return numberTexts.stream()
                .reduce(NumberText.EMPTY, NumberText::add)
                .getNumber()
                .getValue();
    }

    private static List<NumberText> convertNumberText(final List<String> splitTexts) {
        return splitTexts.stream()
                .map(NumberText::parse)
                .collect(Collectors.toList());
    }

    private static List<String> splitTexts(final String texts) {
        if (hasCustomDelimiter(texts)) {
            return splitCustomDelimiter(texts);
        }

        return asList(texts.split(DEFAULT_DELIMITER));
    }

    private static boolean hasCustomDelimiter(final String texts) {
        return compile(CUSTOM_DELIMITER_PATTERN).matcher(texts).find();
    }

    private static List<String> splitCustomDelimiter(final String texts) {
        final Matcher matcher = compile(CUSTOM_DELIMITER_PATTERN).matcher(texts);
        matcher.find();
        return asList(matcher.group(2).split(matcher.group(1)));
    }

}
