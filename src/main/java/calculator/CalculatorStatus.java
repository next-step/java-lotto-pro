package calculator;

public enum CalculatorStatus {
    INVALID_VALUE("Value is not number"),
    NEGATIVE_NUMBER("Value can not be negative");

    private String message;

    CalculatorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
