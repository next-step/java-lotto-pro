package lotto.lotto;

public class AlreadyExistsBonusLottoNumberException extends RuntimeException {

    public AlreadyExistsBonusLottoNumberException(Lotto lotto, LottoNumber lottoNumber) {
        super(String.format("보너스 번호가 당첨 번호에 존재합니다. (입력값: %s, 당첨 번호: %s)", lottoNumber, lotto));
    }
}
