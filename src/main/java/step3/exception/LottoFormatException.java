package step3.exception;

public class LottoFormatException extends RuntimeException {
    public LottoFormatException() {
    }

    public LottoFormatException(String message) {
        super(message);
    }
}
