package lotto.domain;

import java.util.List;

public class LottoGame {
    private final int tryCount;

    public LottoGame(int tryCount, List<LottoBalls> lottoBalls) {
        this.tryCount = tryCount;
    }



    public int getTryCount() {
        return tryCount;
    }
}
