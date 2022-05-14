package lotto_auto.model;

public class PurchasedLottoCount {
    int count;

    public PurchasedLottoCount(Money money) {
        this.count = money.getMoney()/Lotto.price;
    }

    public int getCount() {
        return count;
    }
}
