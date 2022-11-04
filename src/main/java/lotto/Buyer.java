package lotto;

import java.util.List;

import static lotto.common.Constants.DEFAULT_PRICE;
import static lotto.common.Constants.INIT_NUM;

public class Buyer {

    private Money amount;
    private Lottos lottos;

    public Buyer(String inputMoney) {
        amount = new Money(inputMoney);
        lottos = new Lottos();
    }

    public Buyer(Lottos lottos) {
        this.lottos = lottos;
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
