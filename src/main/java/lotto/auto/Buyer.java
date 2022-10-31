package lotto.auto;

import java.util.ArrayList;
import java.util.List;

import static lotto.auto.common.Constants.DEFAULT_PRICE;

public class Buyer {
    private Money amount;
    private List<Lotto> lotto;

    public Buyer(String inputMoney) {
        amount = new Money(inputMoney);
        lotto = new ArrayList<>();
    }

    public void buyLotto() {
        int cnt = 0;
        while (amount.getMoney() > 0) {
            lotto.add(new Lotto(DEFAULT_PRICE));
            this.amount.substractMoney(DEFAULT_PRICE);
            cnt++;
        }
        System.out.println(cnt + "개를 구매했습니다.");
    }

    public int getAmount() {
        return amount.getMoney();
    }

    public List<Lotto> getLotto() {
        return lotto;
    }
}
