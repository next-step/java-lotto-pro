package study.step4.exception;

public class NotEnoughToBuyLottoException extends RuntimeException {
    public NotEnoughToBuyLottoException(String message) {
        super(message);
    }
}
