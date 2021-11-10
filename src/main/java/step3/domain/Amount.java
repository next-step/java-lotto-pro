package step3.domain;

import step3.common.exception.InvalidParamException;
import step3.domain.constance.LottoConstant;

public class Amount {
    public static final String NOT_ENOUGH_MESSAGE = String.format("최소금액은 %s%s 입니다. 로또를 구매할 수 없습니다.",
        LottoConstant.LOTTO_MINIMUM_PRICE, LottoConstant.WON);

    private final int amount;
    private int remainingAmount;

    public Amount(int amount) {
        valid(amount);

        this.amount = amount;
        this.remainingAmount = amount;
    }

    public void minusAmountFrom(LottoNumbersBundle lottoNumbersBundle) {
        int minusAmount = lottoNumbersBundle.getTotalPrise();
        if (amount < minusAmount) {
            throw new InvalidParamException(String.format("최소금액은 %s%s 입니다. 로또를 구매할 수 없습니다.",
                LottoConstant.LOTTO_MINIMUM_PRICE, LottoConstant.WON));
        }

        remainingAmount -= minusAmount;
    }

    public int buyAvailableQuantity() {
        return this.remainingAmount / LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    public void lottoBuyAndAmountMinus(int buyQuantity) {
        if (!isBuyAvailableQuantity(buyQuantity)) {
            throw new InvalidParamException(LottoConstant.LACK_OF_AMOUNT);
        }
        int minusAmount = calculateMinusAmount(buyQuantity);
        this.remainingAmount -= minusAmount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isBuyAvailableQuantity(int buyQuantity) {
        return remainingAmount >= calculateMinusAmount(buyQuantity);
    }

    private void valid(int amount) {
        if (isBelowAmount(amount)) {
            throw new InvalidParamException(NOT_ENOUGH_MESSAGE);
        }
    }

    private int calculateMinusAmount(int buyQuantity) {
        return buyQuantity * LottoConstant.LOTTO_MINIMUM_PRICE;
    }

    private boolean isBelowAmount(int amount) {
        return amount < LottoConstant.LOTTO_MINIMUM_PRICE;
    }

}
