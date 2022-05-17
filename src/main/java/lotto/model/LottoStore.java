package lotto.model;

import lotto.constant.LottoRoleConst;

public class LottoStore {

    private final Money money;

    public LottoStore(Money money) {
        this.money = money;
    }

    public LottoPaper issueLottoPaper() {
        int gameCount = money.getMoney() / LottoRoleConst.LOTTO_PRICE;
        return new LottoPaper(gameCount);
    }
}
