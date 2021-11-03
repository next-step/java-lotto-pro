package lotto.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class LottoResult {

    private final Map<Integer, Integer> matchCountMap = new LinkedHashMap<>();
    private double yield;
    private int matchCount;
    private BigDecimal winningReward = new BigDecimal("0");

    public LottoResult() {
        matchCountMap.put(3, 0);
        matchCountMap.put(4, 0);
        matchCountMap.put(5, 0);
        matchCountMap.put(6, 0);
    }

    public void addMatchCountMap(int matchCount){

        if (matchCountMap.containsKey(matchCount)) {
            matchCountMap.put(matchCount, matchCountMap.get(matchCount) + 1);
        }
    }

    public void calculateYield(long buyPrice) {
        double tempYield = (double)calculateWinningReward().longValue() / buyPrice;
        this.yield =  Math.floor((tempYield * 100)) / 100.0;
    }

    public BigDecimal calculateWinningReward() {
        winningReward = new BigDecimal("0");
        matchCountMap.forEach(this::getWinningReward) ;
        return this.winningReward;
    }

    public void getWinningReward(int match, int matchCount) {

        Optional<LottoWinningPrice> optionalLottoWinningPrice =
                Arrays.stream(LottoWinningPrice.values())
                        .filter(lottoWinningPrice -> match == lottoWinningPrice.getWinningCount()).findFirst();
        if (optionalLottoWinningPrice.isPresent()) {
            long reward = (long) optionalLottoWinningPrice.get().getReward() * matchCount;
            winningReward = winningReward.add(BigDecimal.valueOf(reward));
        }
    }

    public String getLottoResult() {

        StringBuilder resultMsg = new StringBuilder();
        resultMsg.append("당첨 통계\n");
        resultMsg.append("---------\n");

        Arrays.stream(LottoWinningPrice.values()).forEach(
                lottoWinningPrice
                        -> resultMsg.append(String.format("%d개 일치 (%d원) - %d개\n",
                        lottoWinningPrice.getWinningCount(), 
                        lottoWinningPrice.getReward(), 
                        matchCountMap.get(lottoWinningPrice.getWinningCount()) )) );

        resultMsg.append(String.format("총 수익률은 %f 입니다.", yield));
        return resultMsg.toString();
    }

    public int getMatchCount() {
        return matchCount;
    }

    public void addMatchCount() {
        matchCount++;
    }

    public void clearMatchCount() {
        matchCount = 0;
    }
    public Map<Integer, Integer> getMatchCountMap() {
        return matchCountMap;
    }

    public double getYield() {
        return yield;
    }
}
