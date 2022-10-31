package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        validateDuplicatedLottoNumber(winningLotto, bonusLottoNumber);
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public Rank match(Lotto lotto) {
        return Rank.of(winningLotto.match(lotto), lotto.match(bonusLottoNumber));
    }

    private void validateDuplicatedLottoNumber(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        if (winningLotto.match(bonusLottoNumber)) {
            throw new IllegalArgumentException("중복된 번호는 보너스 번호로 입력할 수 없습니다.");
        }
    }

}
