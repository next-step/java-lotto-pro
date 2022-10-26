package util;

public class CustomDelimiterParseResult {
    private final String customDelimiter;
    private final String numberString;

    public CustomDelimiterParseResult(String customDelimiter, String numberString) {

        this.customDelimiter = customDelimiter;
        this.numberString = numberString;
    }

    public static CustomDelimiterParseResult of(String customDelimiter, String numberString) {
        return new CustomDelimiterParseResult(customDelimiter,numberString);
    }

    public String getCustomDelimiter(){
        return this.customDelimiter;
    }

    public String getNumberString() {
        return numberString;
    }
}
