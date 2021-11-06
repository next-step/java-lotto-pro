package lotto.domain;

public class LottoGame {
    private final int tryCount;

    public LottoGame(int tryCount) {
        this.tryCount = tryCount;
    }

    public int getTryCount() {
        return tryCount;
    }
}
