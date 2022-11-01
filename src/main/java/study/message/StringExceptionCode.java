package study.message;

public enum StringExceptionCode {

    NOT_MATCH_CUSTOM_PATTERN("The given string cannot be matched with a custom pattern.");

    private static final String title = "[ERROR] ";
    private String message;

    StringExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return title + message;
    }
}
