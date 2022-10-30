package study.step3;

import study.step3.constants.PatternConstants;
import study.step3.exception.LottoInputMoneyTypeException;

public class Money {
    private final String money;

    public Money(String money) {
        validatePositiveNumber(money);
        this.money = money;
    }

    private void validatePositiveNumber(String money) {
        if (!PatternConstants.ONLY_NUMBER_REGEX.matcher(money).matches()) {
            throw new LottoInputMoneyTypeException("금액은 양수로 이루어진 숫자여야 합니다.");
        }
    }

    public int dividedBy(int pricePerLotto) {
        return Integer.parseInt(money) / pricePerLotto;
    }

    public double divide(int totalReward) {
        return totalReward / Double.parseDouble(money);
    }
}
