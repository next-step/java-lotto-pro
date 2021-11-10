package lotto.model;

import lotto.exception.UnexpectValueException;

import static lotto.common.Constants.GAME_PRICE;

public class GameCount {

    private static final String INVALID_VALUE_MESSAGE = "최소 구매 금액은 %s원입니다.";

    private final int count;

    public GameCount(final int purchaseAmount) {
        validate(purchaseAmount);
        this.count = purchaseAmount / GAME_PRICE;
    }

    public int getValue() {
        return count;
    }

    private void validate(int purchaseAmount) {
        if (purchaseAmount < GAME_PRICE) {
            throw new UnexpectValueException(String.format(INVALID_VALUE_MESSAGE, GAME_PRICE));
        }
    }

}
