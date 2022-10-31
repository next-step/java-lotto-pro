package study.message;

public enum NumberExceptionCode {

    NOT_CONTAINS_ZERO("The given string cannot contain zero."),
    INVALID_NUMBER_STRING("The given string contains characters " +
            "that cannot be converted to numbers."),
    NOT_CONTAINS_NEGATIVE_NUMBER("The given string cannot contain negative numbers."),
    NOT_DIVIDE_ZERO("It cannot be divided by zero.");

    private static final String title = "[ERROR] ";
    private String message;

    NumberExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return title + message;
    }
}
