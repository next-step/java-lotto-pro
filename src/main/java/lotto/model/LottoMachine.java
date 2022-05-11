package lotto.model;

import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buy(int cost) {
        int quantity = getQuantity(cost);
        return new Lottos(quantity);
    }

    private int getQuantity(int cost) {
        return cost / LOTTO_PRICE;
    }

    public double calculateProfit(int cost, List<Result> results) {
        int totalPrizeMoney = results.stream().mapToInt(Result::getPrizeMoney).sum();
        return (totalPrizeMoney * 1.00) / (cost * 1.00);
    }
}
