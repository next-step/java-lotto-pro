package nextstep.lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusBall bonusBall;

    public WinningLotto(Lotto winningLotto, BonusBall bonusBall) {
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public Integer matchWithPurchaseLottoCount(Lotto purchaseLotto) {
        return winningLotto.matchWithPurchaseLottoCount(purchaseLotto);
    }

    public Boolean isBonusBallContains(Lotto purchased) {
        return bonusBall.isContain(purchased);
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }
}
