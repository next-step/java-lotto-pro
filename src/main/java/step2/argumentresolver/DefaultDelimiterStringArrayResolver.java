package step2.argumentresolver;

public class DefaultDelimiterStringArrayResolver implements StringArrayResolver {

    private final String DELIMITER_COMMA = ",";
    private final String DELIMITER_COLON = ":";
    private final int NO_DELIMITER = -1;

    @Override
    public boolean canResolve(String source) {
        return haveDelimiter(source, DELIMITER_COLON) || haveDelimiter(source, DELIMITER_COMMA);
    }

    @Override
    public String[] resolve(String source) {
        return source.split(DELIMITER_COLON+"|"+DELIMITER_COMMA);
    }

    private boolean haveDelimiter(String source, String delimiter) {
        return source.indexOf(delimiter) != NO_DELIMITER;
    }
}
