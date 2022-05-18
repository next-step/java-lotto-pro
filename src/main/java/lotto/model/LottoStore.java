package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoRoleConst;

public class LottoStore {

    private final Money money;

    public LottoStore(Money money) {
        this.money = money;
    }

    public LottoStore(Money money, LottoPaper lottoPaper) {
        this.money = money;
        int gameCount = money.getMoney() / LottoRoleConst.LOTTO_PRICE;
        validateOverCount(gameCount,lottoPaper);
    }

    public LottoStore(Money money, LottoSelfCount lottoSelfCount) {
        this.money = money;
    }

    private void validateOverCount(int gameCount, LottoPaper lottoPaper) {
        if (gameCount < lottoPaper.getSelfCount()){
            throw new IllegalArgumentException(ErrorMessage.NOT_ENOUGH_MEONY);
        }
    }

    public LottoPaper issueLottoPaper() {
        int gameCount = money.getMoney() / LottoRoleConst.LOTTO_PRICE;
        return new LottoPaper(gameCount);
    }
}
