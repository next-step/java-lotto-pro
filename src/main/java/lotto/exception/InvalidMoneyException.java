package lotto.exception;

public class InvalidMoneyException extends IllegalArgumentException {
    private static final String INVALID_MONEY_ERROR_TEXT = "로또 구입 가격은 1000단위의 양수로 입력해야 합니다.";

    public InvalidMoneyException() {
        super(INVALID_MONEY_ERROR_TEXT);
    }
}
