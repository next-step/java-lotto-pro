package lotto.model.vo;

import java.util.Objects;
import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class PurchaseInfo {

    long purchaseAmount;
    long purchaseCount;

    public PurchaseInfo(long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        this.purchaseAmount = purchaseAmount;
        checkLottoUnitPrice(); // 개수 유효성 체크
        checkChange(purchaseAmount); // 잔액 발생 확인
        //개수 계산
        this.purchaseCount = calculatePurchaseCount(purchaseAmount);
        validatePositive(purchaseCount);
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        if (purchaseAmount < LottoConstants.LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_AMOUNT_NOT_ENOUGH);
        }
    }

    private void checkLottoUnitPrice() {
        if (LottoConstants.LOTTO_UNIT_PRICE <= 0) {
            throw new RuntimeException(ErrorMessage.INVALID_LOTTO_UNIT_PRICE);
        }
    }

    private void checkChange(long purchaseAmount) {
        if (purchaseAmount % LottoConstants.LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_PURCHASE_AMOUNT);
        }
    }

    protected static long calculatePurchaseCount(long purchaseAmount) {
        return purchaseAmount / LottoConstants.LOTTO_UNIT_PRICE;
    }

    private void validatePositive(long purchaseCount) {
        if (purchaseCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_COUNT_MUST_POSITIVE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseInfo that = (PurchaseInfo) o;
        return purchaseCount == that.purchaseCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseCount);
    }

    public long getPurchaseCount() {
        return purchaseCount;
    }
}
