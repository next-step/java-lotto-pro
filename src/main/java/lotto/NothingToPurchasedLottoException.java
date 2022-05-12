package lotto;

import lotto.lotto.Lotto;
import lotto.money.Money;

public class NothingToPurchasedLottoException extends RuntimeException {

    public NothingToPurchasedLottoException(Money money, Lotto lotto) {
        super(String.format("구매한 Lotto가 없습니다. (금액: %s, Lotto 가격: %s)", money, lotto.price()));
    }
}
