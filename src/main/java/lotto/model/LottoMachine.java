package lotto.model;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public Lottos buy(int cost) {
        int quantity = getQuantity(cost);
        return new Lottos(quantity);
    }

    private int getQuantity(int cost) {
        return cost / LOTTO_PRICE;
    }

}
