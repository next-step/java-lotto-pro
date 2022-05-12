package camp.nextstep.edu.step2;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String regex = "//(.)\n(.*)";

    public static String[] differentiate(final String input) {
        Optional<String[]> hasSplittingNumbers = splitByCustomDelimiter(input);
        return hasSplittingNumbers.orElseGet(() -> input.split(",|:"));
    }

    private static Optional<String[]> splitByCustomDelimiter(String input) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return Optional.of(m.group(2).split(customDelimiter));
        }
        return Optional.empty();
    }
}
