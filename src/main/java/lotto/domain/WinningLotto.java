package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String numbers, int bonus) {
        this.winningLotto = new Lotto(LottoNumbers.from(numbers));
        LottoNumber bonusNumber = LottoNumber.from(bonus);
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(LottoNumber bonusNumber) {
        if (this.winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복되면 안됩니다.");
        }
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(winningLotto.matchCounts(lotto), lotto.contains(bonusNumber));
    }
}
