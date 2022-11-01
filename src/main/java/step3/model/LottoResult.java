package step3.model;

import step3.constant.WinnerRule;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static step3.constant.Constant.Number.*;
import static step3.constant.Constant.Lotto.*;

public class LottoResult {

    private HashMap<Integer, Integer> result = new HashMap<>();
    private int totalPurchasedPrice;
    private int totalWinnerPrice = 0;
    private double profitRate;

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

    private void sumWinnerPrice() {
        for (Integer winnerKey : result.keySet()) {
            Map<Integer, Integer> rules = WinnerRule.getRules();
            totalWinnerPrice += Optional.ofNullable(rules.get(winnerKey)).orElse(0) * result.get(winnerKey);
        }
    }

    private void calculateProfit() {
        int ymep = totalWinnerPrice;
        int ddd = totalPurchasedPrice;

        profitRate = Math.floor(Double.valueOf(totalWinnerPrice) / totalPurchasedPrice * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public boolean isNotExistsCount(int sameCount) {
        return result.get(sameCount) == null;
    }

    public String getResultValue(int winnerKey) {
        return Optional.ofNullable(result.get(winnerKey)).orElse(ZERO).toString();
    }
}
