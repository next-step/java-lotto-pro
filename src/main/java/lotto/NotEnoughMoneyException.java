package lotto;

import lotto.money.Money;

public class NotEnoughMoneyException extends RuntimeException {

    public NotEnoughMoneyException(Money money, Purchasable purchasable) {
        super(String.format("Money가 충분하지 않습니다. (금액: %s, Lotto 가격: %s)", money, purchasable.price()));
    }
}
