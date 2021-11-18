package lotto.exception;

public class NotEnoughMoneyException extends IllegalArgumentException {
    public NotEnoughMoneyException() {
        super("돈이 충분하지 않습니다");
    }
}
