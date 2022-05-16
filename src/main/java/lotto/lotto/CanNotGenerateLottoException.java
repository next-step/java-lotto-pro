package lotto.lotto;

public class CanNotGenerateLottoException extends RuntimeException {

    public CanNotGenerateLottoException() {
        super("Lotto를 생성할 수 없습니다.");
    }
}
