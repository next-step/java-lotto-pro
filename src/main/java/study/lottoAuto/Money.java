package study.lottoAuto;

import static study.lottoAuto.MessageUtil.MINIMUM_MONEY_INPUT_ERR_MSG;
import static study.lottoAuto.MessageUtil.NEGATIVE_NUMBER_ERR_MSG;

public class Money {

    private static final int LOTTO_PRICE = 1000;

    private final int money;

    public Money(String userInput) {
        this.money = Integer.parseInt(userInput);
        validateMoney();
    }

    private void validateMoney() {
        if(money < 0)
            throw new IllegalStateException(NEGATIVE_NUMBER_ERR_MSG);
        if(money < LOTTO_PRICE)
            throw new IllegalStateException(MINIMUM_MONEY_INPUT_ERR_MSG);
    }

    public int getPurchaseCount() {
        return money/LOTTO_PRICE;
    }

    public int getMoney() {
        return this.money;
    }
}
