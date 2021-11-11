package lotto.exception;

public class IllegalTicketAmountException extends IllegalArgumentException {
    public IllegalTicketAmountException() {
        super("0 이상의 숫자만 입력할 수 있습니다.");
    }
}
