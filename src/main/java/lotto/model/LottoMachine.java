package lotto.model;

import java.util.List;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buyAuto(int cost, int manualQuantity) {
        int quantity = getQuantity(cost, manualQuantity);
        return new Lottos(quantity);
    }

    private int getQuantity(int cost, int manualQuantity) {
        int quantityPurchase = cost / LOTTO_PRICE;
        return quantityPurchase - manualQuantity;
    }

    public double calculateProfit(int cost, List<Result> results) {
        int totalPrizeMoney = results.stream().mapToInt(Result::getPrizeMoney).sum();
        return (totalPrizeMoney * 1.00) / (cost * 1.00);
    }
}
