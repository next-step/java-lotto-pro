package camp.nextstep.edu.step2;

import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
    private static final String REGEX = "//(.)\n(.*)";
    private static final Pattern customPattern = Pattern.compile(REGEX);

    public static String[] differentiate(final String input) {
        validation(input);
        Optional<String[]> hasSplittingNumbers = splitByCustomDelimiter(input);
        return hasSplittingNumbers.orElseGet(() -> input.split(",|:"));
    }

    private static void validation(final String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("invalid parameter");
        }
    }

    private static Optional<String[]> splitByCustomDelimiter(String input) {
        Matcher m = customPattern.matcher(input);
        if (m.find()) {
            return Optional.of(m.group(2).split(m.group(1)));
        }
        return Optional.empty();
    }
}
