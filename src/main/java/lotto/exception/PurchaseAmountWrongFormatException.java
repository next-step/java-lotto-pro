package lotto.exception;

public class PurchaseAmountWrongFormatException extends RuntimeException {

    public PurchaseAmountWrongFormatException() {
        super("구입금액은 숫자만 입력이 가능합니다.");
    }
}
