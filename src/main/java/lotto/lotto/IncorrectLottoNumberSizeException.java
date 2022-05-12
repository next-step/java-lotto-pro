package lotto.lotto;

public class IncorrectLottoNumberSizeException extends RuntimeException {

    public IncorrectLottoNumberSizeException() {
        super("로또 번호의 갯수가 올바르지 않습니다.");
    }
}
