package study.lottoAuto;

import static study.lottoAuto.MessageUtil.MINIMUM_MONEY_INPUT_ERR_MSG;
import static study.lottoAuto.MessageUtil.NEGATIVE_NUMBER_ERR_MSG;

public class Money {
    private final int money;

    public Money(String userInput) {
        this.money = Integer.parseInt(userInput);
        validateMoney();
    }

    private void validateMoney() {
        if(money < 0)
            throw new IllegalStateException(NEGATIVE_NUMBER_ERR_MSG);
        if(money < 1000)
            throw new IllegalStateException(MINIMUM_MONEY_INPUT_ERR_MSG);
    }

    //구매갯수를 구하는 책임을 여기서 맡을 필요가 있을까...?
    public int getPurchaseCount() {
        return money/1000;
    }

    public int getMoney() {
        return this.money;
    }
}
