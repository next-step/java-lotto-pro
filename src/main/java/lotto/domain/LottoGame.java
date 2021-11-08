package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {
    private TryCount tryCount;
    private List<LottoBalls> lottoBallsList;

    public LottoGame(TryCount tryCount, List<LottoBalls> lottoBalls) {
        this.tryCount = tryCount;
        this.lottoBallsList = lottoBalls;
    }

    public LottoGame(List<LottoBalls> lottoBalls) {
        this.lottoBallsList = lottoBalls;
    }

    public int getManualTryCount() {
        return tryCount.getManualTryCount();
    }

    public int getAutoTryCount() {
        return tryCount.getAutoTryCount();
    }

    public List<LottoBalls> getLottoBallsList() {
        return Collections.unmodifiableList(lottoBallsList);
    }

    public Statistics calculateLottoResult(WinningBalls winningBalls) {
        Statistics statistics = new Statistics();
        for (LottoBalls lottoBalls : lottoBallsList) {
            Ranking ranking = winningBalls.calculateRanking(lottoBalls);
            statistics.record(ranking);
        }
        return statistics;
    }

}
