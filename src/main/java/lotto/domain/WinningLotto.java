package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber lottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber lottoNumber) {
        this.lotto = lotto;
        this.lottoNumber = lottoNumber;
        validateDuplicateBonusNumber();
    }

    private void validateDuplicateBonusNumber() {
        if (this.lotto.existLottoNumber(this.lottoNumber)) {
            throw new IllegalArgumentException(Message.EXIST_DUPLICATE_NUMBER_MESSAGE.getMessage());
        }
    }
}
