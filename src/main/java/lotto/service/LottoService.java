package lotto.service;

public class LottoService {

    public static final int LOTTO_PER_PRICE = 1000;

    public int countPurchasableLotto(int amount) {
        return amount / LOTTO_PER_PRICE;
    }
}
