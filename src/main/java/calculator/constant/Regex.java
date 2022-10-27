package calculator.constant;

public enum Regex {
    ONLY_NUMBER("^[0-9]*$");
    private final String regex;
    Regex(String regex) {
        this.regex = regex;
    }
    public String getRegex() {
        return regex;
    }
}
