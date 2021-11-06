package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class LottoResult {

    private final Map<Rank, Integer> lottoMatchResult;

    public LottoResult(Map<Rank, Integer> lottoMatchResult) {
        this.lottoMatchResult = lottoMatchResult;
    }

    public int getMatchRankCount(Rank rank) {
        return lottoMatchResult.get(rank);
    }

    public double getLottoYield() {
        double purchaseAmount = getPurchaseAmount();
        double sum = getPrizeMoneySum() / purchaseAmount;
        double yield = getMatchAround(sum, 3);
        return yield;
    }

    private int getPrizeMoneySum() {
        int sum = 0;
        for (Rank rank : lottoMatchResult.keySet()) {
            sum += rank.getPrizeMoney() * lottoMatchResult.get(rank);
        }
        return sum;
    }

    private int getPurchaseAmount() {
        return lottoMatchResult.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum() * GAME_PRICE;
    }

    private double getMatchAround(double value, int position) {
        double ndb = Math.pow(10.0, position);
        return (Math.round(value * ndb) / ndb);
    }

}
