package lotto.message;

import lotto.domain.Money;

public class InputMessage {
    public static final String INVALID_MINIMUM_MONEY = String.format("최소 %d원 이상이어야 구매할 수 있습니다.", Money.MINIMUM_MONEY);
}
