package step3.model;

import step3.constant.Rank;

import java.util.HashMap;
import java.util.Optional;

import static step3.constant.Constant.Lotto.EACH_LOTTO_PRICE;
import static step3.constant.Constant.Number.ONE_HUNDRED;
import static step3.constant.Constant.Number.ZERO;

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

    public void addResult(int sameCount, boolean isBonus) {
        Rank rank = Rank.valueOf(sameCount, isBonus);
        if (isNotExistsCount(rank)) {
            result.put(rank, 0);
        }
        int count = result.get(rank);
        result.put(rank, ++count);

        result.get(rank);
    }

    public double calculateProfitRate(int size) {
        totalPurchasedPrice = EACH_LOTTO_PRICE * size;
        sumWinnerPrice();
        calculateProfit();
        return profitRate;
    }

    public void sumWinnerPrice() {
        for (Rank rank : result.keySet()) {
            totalWinnerPrice += Optional.ofNullable(result.get(rank)).orElse(0) * rank.getWinningMoney();
        }
    }

    private void calculateProfit() {
        profitRate = Math.floor(Double.valueOf(totalWinnerPrice) / totalPurchasedPrice * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public boolean isNotExistsCount(Rank rank) {
        return !result.containsKey(rank);
    }

    public String getWinningCount(Rank rank) {
        return Optional.ofNullable(result.get(rank)).orElse(ZERO).toString();
    }
}
