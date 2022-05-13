package step2.argumentresolver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomDelimiterStringArrayResolver implements StringArrayResolver {

    private final String REGEX = "//(.)\n(.*)";
    private final Pattern pattern = Pattern.compile(REGEX);
    private final int DELIMITER_GROUP = 1;
    private final int SPLIT_SOURCE_GROUP = 2;

    @Override
    public boolean canResolve(String source) {
        return pattern.matcher(source).find();
    }

    @Override
    public String[] resolve(String source) {
        Matcher delimiterMatcher = pattern.matcher(source);

        delimiterMatcher.find();
        String delimiter = delimiterMatcher.group(DELIMITER_GROUP);
        String splitSource = delimiterMatcher.group(SPLIT_SOURCE_GROUP);

        return splitSource.split(delimiter);
    }
}
