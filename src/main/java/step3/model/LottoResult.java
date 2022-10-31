package step3.model;

import step3.constant.Rank;

import java.util.HashMap;
import java.util.Optional;

import static step3.constant.Constant.*;
import static step3.constant.WinnerRule.rules;

public class LottoResult {

    private HashMap<Rank, Integer> result = new HashMap<>();
    private int totalPurchasedPrice;
    private int totalWinnerPrice = 0;
    private double profitRate;

    public void addResult(int sameCount, boolean isBonus) {
        if (isNotExistsCount(sameCount)) {
            result.put(Rank.valueOf(sameCount, isBonus), 0);
        }
        int count = result.get(Rank.valueOf(sameCount, isBonus));
        result.put(Rank.valueOf(sameCount, isBonus), ++count);
    }

    public double calculateProfitRate(int size) {
        totalPurchasedPrice = EACH_LOTTO_PRICE * size;
        sumWinnerPrice();
        calculateProfit();
        return profitRate;
    }

//    private void sumWinnerPrice() {
//        for (Integer winnerKey : result.keySet()) {
//            totalWinnerPrice += Optional.ofNullable(rules.get(winnerKey)).orElse(0) * result.get(winnerKey);
//        }
//    }

    private void sumWinnerPrice() {
        for (Rank rank : result.keySet()) {
            totalWinnerPrice += Optional.ofNullable(result.get(rank)).orElse(0) * rank.getWinningMoney();
        }
    }

    private void calculateProfit() {
        profitRate = Math.floor(Double.valueOf(totalWinnerPrice) / totalPurchasedPrice * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public boolean isNotExistsCount(int sameCount) {
        return result.get(sameCount) == null;
    }

//    public String getResultValue(int winnerKey) {
//        return Optional.ofNullable(result.get(winnerKey)).orElse(ZERO).toString();
//    }

    public String getResultValue(Rank rank) {
        return Optional.ofNullable(result.get(rank)).orElse(ZERO).toString();
    }
}
