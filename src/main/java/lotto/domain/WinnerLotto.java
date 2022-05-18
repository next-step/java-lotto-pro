package lotto.domain;

public class WinnerLotto {
    private final Lotto winnerLotto;
    private final LottoNumber bonusBall;

    public WinnerLotto(Lotto winnerLotto, LottoNumber bonusBall) {
        if (winnerLotto.isContain(bonusBall)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 로또 번호에 포함되어 있으면 안됩니다.");
        }
        this.bonusBall = bonusBall;
        this.winnerLotto = winnerLotto;
    }

    public LottoRank match(Lotto lotto) {
        return LottoRank.reword(lotto.matchCount(winnerLotto), lotto.isContain(bonusBall));
    }

}
