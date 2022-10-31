package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    public Rank match(Lotto lotto) {
        return Rank.of(winningLotto.match(lotto));
    }


}
