package step3.model;

import step3.constant.Rank;

import step3.constant.WinnerRule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static step3.constant.Constant.Number.*;
import static step3.constant.Constant.Lotto.*;

public class LottoResult {

    private HashMap<Rank, Integer> result = new HashMap<>();
    private int totalPurchasedPrice;
    private int totalWinnerPrice = 0;
    private double profitRate;

    public int getTotalWinnerPrice() {
        return totalWinnerPrice;
    }
    public double getProfitRate() {
        return profitRate;
    }

    public void addResult(int sameCount) {
        if (isNotExistsCount(sameCount)) {
            result.put(sameCount, 0);
        }
        int count = result.get(sameCount);
        result.put(sameCount, ++count);
    }

    public double calculateProfitRate(int size) {
        totalPurchasedPrice = EACH_LOTTO_PRICE * size;
        sumWinnerPrice();
        calculateProfit();
        return profitRate;
    }

    public void addResult(int sameCount, boolean isBonus) {
        if (isNotExistsCount(sameCount)) {
            result.put(Rank.valueOf(sameCount, isBonus), 0);
        }
        int count = result.get(Rank.valueOf(sameCount, isBonus));
        result.put(Rank.valueOf(sameCount, isBonus), ++count);
    }

    private void sumWinnerPrice() {
        for (Rank rank : result.keySet()) {
            totalWinnerPrice += Optional.ofNullable(result.get(rank)).orElse(0) * rank.getWinningMoney();
        }
    }

    private void calculateProfit() {
        profitRate = Math.floor(Double.valueOf(totalWinnerPrice) / totalPurchasedPrice * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public boolean isNotExistsCount(int sameCount) {
        return !result.containsKey(sameCount);
    }

    public String getWinningCount(Rank rank) {
        return Optional.ofNullable(result.get(rank)).orElse(ZERO).toString();
    }
}
