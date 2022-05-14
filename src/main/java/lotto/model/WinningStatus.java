package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningStatus {

    private final Map<MatchPoint, Integer> winningStatus;

    public WinningStatus() {
        winningStatus = new HashMap<>();
        for (MatchPoint value : MatchPoint.values()) {
            winningStatus.put(value, 0);
        }
    }

    protected void recordResults(int count) {

        MatchPoint matchPoint = MatchPoint.findMatchPointByMatchPointCount(count);
        if(matchPoint != null){
            winningStatus.put(matchPoint, winningStatus.get(matchPoint) + 1);
        }
    }

    public int findWinningCount(MatchPoint matchPoint) {
        return winningStatus.get(matchPoint);
    }

    public double findEarningsRate(long lottosTotalPrice) {
        long sum = 0;

        for (MatchPoint matchPoint : MatchPoint.values()) {
            sum = sum + matchPoint.sumCashPrizeByMatchPoint(winningStatus.get(matchPoint));
        }

        return Math.floor(((double) sum/lottosTotalPrice) * 100) / 100.0;
    }
}
