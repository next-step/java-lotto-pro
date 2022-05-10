package level1.stringCaluator.until;

public class StringParser {
    private final static String DEFAULT_SPLIT_SEPARATOR_REGEX = "[:,]";
    private final static String  SPECIAL_SPLIT_LEFT_SEPARATOR = "//";
    private final static String  SPECIAL_SPLIT_RIGHT_SEPARATOR = "\n";

    private StringParser() {}

    public static String[] parseAndSplit(String target) {
        String splitTarget = target;
        String separator = parseSplitSeparator(target);

        if (!separator.equals(DEFAULT_SPLIT_SEPARATOR_REGEX)) {
            splitTarget = splitTarget.substring(splitTarget.indexOf(SPECIAL_SPLIT_RIGHT_SEPARATOR) + 1);
        }

        return splitTarget.split(separator);
    }

    private static String parseSplitSeparator(String target) {
        String separator = DEFAULT_SPLIT_SEPARATOR_REGEX;
        int specialSplitLeftSeparatorIndex = target.indexOf(SPECIAL_SPLIT_LEFT_SEPARATOR);
        int specialSplitRightSeparatorIndex = target.indexOf(SPECIAL_SPLIT_RIGHT_SEPARATOR);

        if (specialSplitLeftSeparatorIndex == 0 && specialSplitRightSeparatorIndex > 0) {
            separator = target.substring(
                specialSplitLeftSeparatorIndex + SPECIAL_SPLIT_LEFT_SEPARATOR.length(),
                specialSplitRightSeparatorIndex
            );
        }

        return separator;
    }
}
