package study.step4.models;

import study.step4.constants.PatternConstants;
import study.step4.exception.LottoInputMoneyInvalidUnitException;
import study.step4.exception.LottoInputMoneyTypeException;
import study.step4.exception.NotEnoughToBuyLottoException;

public class Money {
    public static final int PRICE_PER_LOTTO = 1000;

    private final int money;

    public Money(String money) {
        validatePositiveNumber(money);
        validateUnitPurchasePrice(money);
        this.money = Integer.parseInt(money);
    }

    private void validateUnitPurchasePrice(String money) {
        int parsedMoney = Integer.parseInt(money);
        if (parsedMoney == 0 || parsedMoney % PRICE_PER_LOTTO != 0) {
            throw new LottoInputMoneyInvalidUnitException(String.format("구매 단위(%d)에 맞게 기입해야 합니다.", PRICE_PER_LOTTO));
        }
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

    public void validateEnoughToBuyLotto(int numberOfManualLotto) {
        if (PRICE_PER_LOTTO * numberOfManualLotto > money) {
            throw new NotEnoughToBuyLottoException("로또를 사기에 금액이 부족합니다.");
        }
    }
}
