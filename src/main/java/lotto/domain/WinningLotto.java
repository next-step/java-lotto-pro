package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank confirm(Lotto lotto) {
        int matcheCount = this.lotto.matche(lotto);
        boolean matchBonus = lotto.contains(bonusNumber);

        return Rank.valueOf(matcheCount, matchBonus);
    }
}
