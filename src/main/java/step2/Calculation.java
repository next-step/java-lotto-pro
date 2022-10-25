package step2;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculation {

    private static final String SEPARATOR = ",|:";


    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("\\/\\/(.)\n(.*)");

    private static final int CUSTOM_SEPARATOR_GROUP = 1;

    private static final int NUMBER_SEPARATOR_GROUP = 2;

    private List<String> splitNumbers;

    public Calculation(final String input) {
        splitNumbers = split(input);
    }

    private static List<String> split(final String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if(matcher.find()) {
            String group = matcher.group(CUSTOM_SEPARATOR_GROUP);
            return Arrays.asList(matcher.group(NUMBER_SEPARATOR_GROUP).split(group));
        }

        return Arrays.asList(input.split(SEPARATOR));
    }

    public static boolean isNullOrEmpty(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }

    public List<String> getSplitNumbers() {
        return splitNumbers;
    }
}
