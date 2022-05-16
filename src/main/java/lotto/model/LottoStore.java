package lotto.model;

import lotto.constant.LottoRoleConst;

public class LottoStore {

    private final Money money;

    public LottoStore(String moneyWord) {
        this.money = new Money(moneyWord);
    }

    public LottoPaper issueLottoPaper() {
        int gameCount = money.getMoney() / LottoRoleConst.LOTTO_PRICE;
        return new LottoPaper(gameCount);
    }
}
