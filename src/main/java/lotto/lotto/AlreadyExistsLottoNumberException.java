package lotto.lotto;

public class AlreadyExistsLottoNumberException extends RuntimeException {

    public AlreadyExistsLottoNumberException() {
        super("이미 존재하는 로또 번호가 있습니다.");
    }
}
