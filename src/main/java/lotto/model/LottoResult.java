package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoWinningPrice, Integer> matchCounts = new LinkedHashMap<>();
    private double yield;
    private BigDecimal winningReward = new BigDecimal("0");

    public LottoResult() {
        matchCounts.put(LottoWinningPrice.THREE, 0);
        matchCounts.put(LottoWinningPrice.FOUR, 0);
        matchCounts.put(LottoWinningPrice.FIVE, 0);
        matchCounts.put(LottoWinningPrice.SIX, 0);
        matchCounts.put(LottoWinningPrice.BONUS, 0);
    }

    public void addMatchCounts(int matchCount, boolean isBonus){
        LottoWinningPrice lottoWinningPrice = LottoWinningPrice.getLottoWinningPrice(matchCount, isBonus);
        if(!lottoWinningPrice.isView()){
            return;
        }
        if(lottoWinningPrice == LottoWinningPrice.BONUS){
            winningBonus();
            return;
        }
        matchCounts.put(lottoWinningPrice, matchCounts.get(lottoWinningPrice) + 1);
    }

    public void winningBonus() {
        if(matchCounts.get(LottoWinningPrice.FIVE) > 0){
            matchCounts.put(LottoWinningPrice.FIVE, matchCounts.get(LottoWinningPrice.FIVE) - 1);
        }
        matchCounts.put(LottoWinningPrice.BONUS, matchCounts.get(LottoWinningPrice.BONUS) + 1);
    }

    public void calculateYield(long buyPrice) {
        this.yield = calculateWinningReward().divide(new BigDecimal(buyPrice), 2, RoundingMode.FLOOR).doubleValue();
    }

    public BigDecimal calculateWinningReward() {
        winningReward = new BigDecimal("0");
        matchCounts.forEach(this::addWinningReward) ;
        return this.winningReward;
    }

    public void addWinningReward(LottoWinningPrice lottoWinningPrice, int matchCount) {
        if(lottoWinningPrice.isView()){
            long reward = (long) lottoWinningPrice.getReward() * matchCount;
            winningReward = winningReward.add(BigDecimal.valueOf(reward));
        }
    }

    public Map<LottoWinningPrice, Integer> getMatchCounts() {
        return matchCounts;
    }

    public double getYield() {
        return yield;
    }
}
