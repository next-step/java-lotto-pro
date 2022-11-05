package study.lotto.domain.order;

import study.lotto.domain.Store;
import study.message.LottoExceptionCode;
import study.util.NumberUtil;

public class Quantity {

    private static final int MIN_QUANTITY = 0;

    private final int quantity;

    public Quantity(String amount) {
        this.quantity = (int) NumberUtil.divideAndCeil(checkAmount(amount), Store.LOTTO_PRICE);
    }

    private int checkAmount(String amount) {
        try {
            int amountConverted = NumberUtil.convertToPositiveIntNotContainsZero(amount);
            checkLottoPrice(amountConverted);

            return amountConverted;
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
        }
    }

    private void checkLottoPrice(int amount) {
        if (amount < Store.LOTTO_PRICE) {
            throw new IllegalArgumentException(LottoExceptionCode.INSUFFICIENT_FUNDS.getMessage());
        }
    }

    public int getAutoQuantity(int manualQuantity) {
        if(isValidManualOrder(manualQuantity)) {
            return quantity - manualQuantity;
        }
        return quantity;
    }

    public boolean isValidManualOrder(int manualQuantity) {
        return MIN_QUANTITY <= manualQuantity && manualQuantity <= quantity;
    }
}
