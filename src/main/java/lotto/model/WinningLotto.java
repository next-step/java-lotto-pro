package lotto.model;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    private WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validateBonusLottoNumber(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(winningLotto, bonusLottoNumber);
    }

    public Lotto winningLotto() {
        return winningLotto;
    }

    public LottoNumber bonusLottoNumber() {
        return bonusLottoNumber;
    }

    public void validateBonusLottoNumber(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if (winningLotto.containLottoNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException("중복되는 로또 번호 입니다.");
        }
    }
}
