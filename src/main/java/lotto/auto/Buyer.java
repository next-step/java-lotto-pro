package lotto.auto;

import java.util.List;

import static lotto.auto.common.Constants.DEFAULT_PRICE;

public class Buyer {
    private static final int INIT_NUM = 0;

    private Money amount;
    private Lottos lottos;

    public Buyer(String inputMoney) {
        amount = new Money(inputMoney);
        lottos = new Lottos();
    }

    public int buyLotto() {
        int cnt = INIT_NUM;
        while (amount.getMoney() > 0) {
            lottos.add(new Lotto());
            this.amount.substractMoney(DEFAULT_PRICE);
            cnt++;
        }
        return cnt;
    }

    public int getAmount() {
        return amount.getMoney();
    }

    public List<Lotto> getLottos() {
        return lottos.getLottos();
    }
}
