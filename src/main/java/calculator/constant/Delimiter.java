package calculator.constant;

public enum Delimiter {
    BASIC_DELIMITER("[,:]"),
    CUSTOM_DELIMITER("//(.)\n(.*)");
    private final String delimiter;
    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }
    public String getDelimiter() {
        return delimiter;
    }
}
