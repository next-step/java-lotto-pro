package lotto.domain;

import java.util.Map;

import static lotto.domain.LottoNumber.GAME_PRICE;

public class LottoResult {

    private final static int DECIMAL_POINT = 3;

    private final Map<Rank, Integer> lottoMatchResult;

    public LottoResult(Map<Rank, Integer> lottoMatchResult) {
        this.lottoMatchResult = lottoMatchResult;
    }

    public int getMatchRankCount(Rank rank) {
        return lottoMatchResult.getOrDefault(rank, 0);
    }

    public double getLottoYield() {
        double sum = getPrizeMoneySum() / getPurchaseAmount(GAME_PRICE);
        double yield = getMatchAround(sum, DECIMAL_POINT);
        return yield;
    }

    private int getPrizeMoneySum() {
        int sum = 0;
        for (Rank rank : lottoMatchResult.keySet()) {
            sum += rank.getPrizeMoney() * lottoMatchResult.get(rank);
        }
        return sum;
    }

    private int getPurchaseAmount(int gamePrice) {
        return lottoMatchResult.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum() * gamePrice;
    }

    private double getMatchAround(double value, int position) {
        double ndb = Math.pow(10.0, position);
        return (Math.round(value * ndb) / ndb);
    }

}
