package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoGame {
    private int tryCount;
    private int manualTryCount;
    private int autoTryCount;
    private List<LottoBalls> lottoBallsList;

    public LottoGame(int manualTryCount, int autoTryCount, List<LottoBalls> lottoBalls) {
        this.manualTryCount = manualTryCount;
        this.autoTryCount = autoTryCount;
        this.lottoBallsList = lottoBalls;
    }

    public LottoGame(List<LottoBalls> lottoBalls) {
        this.lottoBallsList = lottoBalls;
    }

    public int getTryCount() {
        return tryCount;
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
