package study.lotto.domain.order;

import study.lotto.domain.Lotto;
import study.lotto.domain.Store;

import java.util.List;

public class AutoOrder implements Order {

    private int quantity = 0;

    AutoOrder(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public List<Lotto> order(UserPurchase purchase) {
        return Store.buyLottosByAuto(quantity);
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
