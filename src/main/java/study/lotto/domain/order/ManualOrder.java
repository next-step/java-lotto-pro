package study.lotto.domain.order;

import study.lotto.domain.Lotto;
import study.lotto.domain.Store;

import java.util.ArrayList;
import java.util.List;

public class ManualOrder implements Order {

    private int quantity = 0;
    private final List<Lotto> lottos = new ArrayList<>();

    ManualOrder(int quantity) {
        this.quantity = quantity;
    }

    public void create(String lotto) {
        lottos.add(Store.buyLottoByManual(lotto));
    }

    @Override
    public List<Lotto> order(UserPurchase purchase) {
        return lottos;
    }

    @Override
    public String toString() {
        return String.valueOf(quantity);
    }
}
