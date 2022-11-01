package study.step3.message;

public enum MoneyMessage {
    ERROR_MONEY_SHOULD_BE_AT_LEAST_ZERO("금액은 0원 이상이어야합니다.");

    private final String message;

    MoneyMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
