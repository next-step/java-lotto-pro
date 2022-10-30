package lotto.domain;

import java.util.Objects;
import lotto.view.OutputView;

public class LottoPurchaseAmount  {
    public static final int LOTTO_PRICE = 1000;

    private final int amount;

    public LottoPurchaseAmount(String inputAmount) {
        this.amount = parseAmount(inputAmount);
        validPositive();
        validMinAmount();
        validThousands();
    }

    private int parseAmount(String inputAmount) {
        try {
            return Integer.parseInt(inputAmount);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(OutputView.ERROR_MESSAGE_INPUT_AMOUNT_ONLY_NUMBER);
        }
    }

    private void validThousands() {
        if (this.amount % LOTTO_PRICE > 0) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_AMOUNT_UNIT_OF_1000);
        }
    }

    private void validPositive() {
        if (this.amount <= 0) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_MINIMUM_PURCHASE_AMOUNT);
        }
    }

    private void validMinAmount() {
        if (this.amount < LOTTO_PRICE) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_MINIMUM_PURCHASE_AMOUNT);
        }
    }

    public int calculateQuantity() {
        return this.amount / LOTTO_PRICE;
    }

    public LottoLottery toLottoLottery(LottoNumberGenerator lottoNumberGenerator) {
        return LottoLottery.of(LottoPurchaseQuantity.of(calculateQuantity()), lottoNumberGenerator);
    }

    public double calculateEarningRatio(long earningAmount) {
        return Math.floor((double) earningAmount / this.amount * 100) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoPurchaseAmount that = (LottoPurchaseAmount) o;
        return amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
