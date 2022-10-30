package step3.model;

import java.util.HashMap;
import java.util.Optional;

import static step3.constant.Constant.*;
import static step3.constant.WinnerRule.rules;
public class LottoResult {

    private HashMap<Integer, Integer> result = new HashMap<>();
    private int totalPurchasedPrice;
    private int totalWinnerPrice = 0;
    private double profitRate;

    public void addResult(int sameCount) {
        if(isNotExistsCount(sameCount)) {
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

    private void calculateProfit() {
        profitRate = Math.floor(Double.valueOf(totalWinnerPrice) / totalPurchasedPrice * ONE_HUNDRED) / ONE_HUNDRED;
    }

    private void sumWinnerPrice() {
        for (Integer winnerKey : result.keySet()) {
            totalWinnerPrice += Optional.ofNullable(rules.get(winnerKey)).orElse(0) * result.get(winnerKey);
        }
    }

    public boolean isNotExistsCount(int sameCount) {
        return result.get(sameCount) == null;
    }

    public String getResultValue(int winnerKey) {
        return Optional.ofNullable(result.get(winnerKey)).orElse(ZERO).toString();
    }
}
