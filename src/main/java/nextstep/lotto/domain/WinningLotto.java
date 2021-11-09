package nextstep.lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    @Override
    public String toString() {
        return winningLotto.toString();
    }
}
