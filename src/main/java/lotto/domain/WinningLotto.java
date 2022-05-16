package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(String numbers, int bonus) {
        Lotto winningLotto = new Lotto(LottoNumbers.of(numbers));
        this.winningLotto = winningLotto;
        LottoNumber bonusNumber = LottoNumber.from(bonus);
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복되면 안됩니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(winningLotto.matchCounts(lotto), lotto.contains(bonusNumber));
    }
}
