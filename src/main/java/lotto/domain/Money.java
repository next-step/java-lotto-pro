package lotto.domain;

import lotto.utils.StringParser;

import java.util.Objects;

import static lotto.constants.LottoGameConstant.LOTTO_TICKET_PRICE;
import static lotto.constants.LottoGameErrorMessage.*;

public class Money {
    private final int money;

    public Money(String money) {
        int parsedMoney = StringParser.parseAsInteger(money);
        validateMoney(parsedMoney);
        this.money = parsedMoney;
    }

    private void validateMoney(int money) {
        validateMinimumSize(money);
        validateSize(money);
    }

    private void validateSize(int parsedMoney) {
        if (parsedMoney % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_LEFT);
        }
    }

    private void validateMinimumSize(int parsedMoney) {
        if (parsedMoney < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(INSUFFICIENT_MONEY);
        }
    }

    public LottoCount calculateLottoTicketCount() {
        return LottoCount.from(this.money / LOTTO_TICKET_PRICE);
    }

    public int getMoney() {
        return money;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money1 = (Money) o;
        return money == money1.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}
