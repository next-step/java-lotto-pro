package nextstep.lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Integer matchWithPurchaseLottoCount(Lotto purchaseLotto) {
        return winningLotto.matchWithPurchaseLottoCount(purchaseLotto);
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }
}
