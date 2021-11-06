package lotto.domain;

import java.util.List;

public class LottoGame {
    private int tryCount;
    private List<LottoBalls> lottoBallsList;

    public LottoGame(int tryCount, List<LottoBalls> lottoBalls) {
        this.tryCount = tryCount;
        this.lottoBallsList = lottoBalls;
    }

    public LottoGame(List<LottoBalls> lottoBalls) {
        this.lottoBallsList = lottoBalls;
    }

    public int getTryCount() {
        return tryCount;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (LottoBalls lottoBalls : lottoBallsList) {
            builder.append("[");
            builder.append(lottoBalls.toString());
            builder.append("]");
            builder.append("\n");
        }
        return builder.toString();
    }
}
