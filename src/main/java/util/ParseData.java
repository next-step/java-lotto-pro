package util;

public class ParseData {
    private static final String defaultDelimiter = ",|:";
    private final String customDelimiter;
    private final String numberString;

    private ParseData(String customDelimiter, String numberString) {
        this.customDelimiter = customDelimiter;
        this.numberString = numberString;
    }

    public static ParseData of(String customDelimiter, String numberString) {
        return new ParseData(customDelimiter,numberString);
    }

    private String getDelimiter(String customDelimiter) {
        String delimiter = defaultDelimiter;
        if(!customDelimiter.isEmpty()){
            delimiter = String.format("%s|%s",defaultDelimiter,customDelimiter);
        }
        return delimiter;
    }

    public String[] split() {
        String delimiter = getDelimiter(this.customDelimiter);
        return numberString.split(delimiter);
    }
}
