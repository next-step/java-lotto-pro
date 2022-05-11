package lotto.model;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public int buy(int cost) {
        return cost / LOTTO_PRICE;
    }

}
