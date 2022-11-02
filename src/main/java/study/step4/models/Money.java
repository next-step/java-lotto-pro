package study.step4.models;

import study.step4.constants.PatternConstants;
import study.step4.exception.LottoInputMoneyTypeException;

public class Money {
    public static final int PRICE_PER_LOTTO = 1000;

    private final int money;

    public Money(String money) {
        validatePositiveNumber(money);
        this.money = Integer.parseInt(money);
    }

    private void validatePositiveNumber(String money) {
        if (!PatternConstants.ONLY_NUMBER_REGEX.matcher(money).matches()) {
            throw new LottoInputMoneyTypeException("금액은 양수로 이루어진 숫자여야 합니다.");
        }
    }

    public int dividedBy(int pricePerLotto) {
        return money / pricePerLotto;
    }

    public double divide(int totalReward) {
        return (double) totalReward / money;
    }
}
