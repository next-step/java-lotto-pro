package lotto.model;

import java.util.HashMap;
import java.util.Map;

public class WinningStatus {

    private final Map<MatchPoint, Integer> winningStatus;

    public WinningStatus() {
        winningStatus = new HashMap<>();
        for (MatchPoint value : MatchPoint.findValues()) {
            winningStatus.put(value, 0);
        }
    }

    protected void recordResults(int count, boolean matchBonus) {

        MatchPoint matchPoint = MatchPoint.findMatchPointByMatchPointCount(count, matchBonus);
        if(matchPoint != MatchPoint.MISS){
            winningStatus.put(matchPoint, winningStatus.get(matchPoint) + 1);
        }
    }

    public int findWinningCount(MatchPoint matchPoint) {
        return winningStatus.get(matchPoint);
    }

    public double findEarningsRate(long lottosTotalPrice) {
        long sum = 0;

        for (MatchPoint matchPoint : MatchPoint.findValues()) {
            sum = sum + matchPoint.sumCashPrizeByMatchPoint(winningStatus.get(matchPoint));
        }

        return Math.floor(((double) sum/lottosTotalPrice) * 100) / 100.0;
    }
}
