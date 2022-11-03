package lotto.domain;

import java.util.Objects;
import lotto.view.OutputView;

public class LottoPurchaseAmount  {
    public static final int LOTTO_PRICE = 1000;

    private final Money amount;

    public LottoPurchaseAmount(Money amount) {
        this.amount = amount;
        validMinAmount();
        validThousands();
    }

    private void validThousands() {
        if (amount.remainder(LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_AMOUNT_UNIT_OF_1000);
        }
    }

    private void validMinAmount() {
        if (amount.isLessThanLottoPrice()) {
            throw new IllegalArgumentException(OutputView.ERROR_MESSAGE_MINIMUM_PURCHASE_AMOUNT);
        }
    }

    public int calculateQuantity() {
        return amount.divide(LOTTO_PRICE);
    }

    public LottoPurchaseQuantity calculateAutoQuantity(LottoPurchaseQuantity manualQuantity) {
        return manualQuantity.calculateAutoQuantity(calculateQuantity());
    }

    public LottoLottery toLottoLottery(LottoNumberGenerator lottoNumberGenerator) {
        return LottoLottery.of(LottoPurchaseQuantity.of(calculateQuantity()), lottoNumberGenerator);
    }

    public double calculateEarningRatio(long earningAmount) {
        return Math.floor(amount.calculateEarningRatio(earningAmount) * 100) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPurchaseAmount that = (LottoPurchaseAmount) o;
        return Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
