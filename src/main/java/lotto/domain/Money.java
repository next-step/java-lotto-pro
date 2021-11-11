package lotto.domain;

import lotto.dto.MoneyDTO;
import lotto.exception.NegativeMoneyException;

public class Money {
    public static final int ZERO = 0;

    private final int money;

    public Money(int money) {
        checkMoneyNegative(money);
        this.money = money;
    }

    public static Money from(String inputMoney) {
        return new Money(Integer.parseInt(inputMoney));
    }

    private void checkMoneyNegative(int money) {
        if (money < ZERO) {
            throw new NegativeMoneyException();
        }
    }

    public MoneyDTO toDTO() {
        return new MoneyDTO(money);
    }

    public int getLottoAmount(int lottoTicketPrice) {
        return money / lottoTicketPrice;
    }
}
