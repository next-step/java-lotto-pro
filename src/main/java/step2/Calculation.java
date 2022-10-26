package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculation {

    private static final String SEPARATOR = ",|:";

    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("\\/\\/(.)\n(.*)");

    private static final int CUSTOM_SEPARATOR_GROUP = 1;

    private static final int NUMBER_SEPARATOR_GROUP = 2;

    public static List<SplitNumber> split(final String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);

        if(matcher.find()) {
            String group = matcher.group(CUSTOM_SEPARATOR_GROUP);
            return splitNumberList(matcher.group(NUMBER_SEPARATOR_GROUP).split(group));
        }
        return splitNumberList(input.split(SEPARATOR));
    }

    private static List<SplitNumber> splitNumberList(final String[] inputs) {
        return Arrays.stream(inputs)
            .map(splitNumber -> new SplitNumber(splitNumber))
            .collect(Collectors.toList());
    }
}
