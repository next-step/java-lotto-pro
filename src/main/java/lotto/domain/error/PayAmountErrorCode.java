package lotto.domain.error;

public enum PayAmountErrorCode {

    ONLY_ALLOW_POSITIVE_NUMBER("payAmount는 양수만 허용합니다. payAmount = %s"),
    ALLOW_MIN_PAY_AMOUNT("허용하는 최소금액은 %d입니다.");

    private final String message;

    PayAmountErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
