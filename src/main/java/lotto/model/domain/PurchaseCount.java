package lotto.model.domain;

import java.util.Objects;
import lotto.model.constants.ErrorMessage;

public class PurchaseCount {

    private long totalCount;
    private long manualLottoCount;

    private PurchaseCount(long totalCount, long manualLottoCount) {
        validateTotalCount(totalCount);
        this.totalCount = totalCount;
        countSizeCheck(manualLottoCount);
        this.manualLottoCount = manualLottoCount;
    }

    public static PurchaseCount totalCountOf(long totalCount) {
        return new PurchaseCount(totalCount, 0);
    }

    private void validateTotalCount(long totalCount) {
        if (totalCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.PURCHASE_TOTAL_COUNT_NOT_POSITIVE);
        }
    }

    private void validateManualLottoCount(long manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException(ErrorMessage.MANUAL_LOTTO_PURCHASE_COUNT_NEGATIVE);
        }
    }

    private long parseManualLottoCount(String manualLottoCount) {
        try {
            return Long.parseLong(manualLottoCount);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MANUAL_LOTTO_PURCHASE_COUNT);
        }
    }

    private void countSizeCheck(long manualLottoCount) {
        if (manualLottoCount > this.totalCount) {
            throw new IllegalArgumentException(ErrorMessage.MANUAL_LOTTO_PURCHASE_COUNT_EXCEED);
        }
    }

    public void manualCountSetting(long manualLottoCount) {
        //manualCount 유효성 체크
        validateManualLottoCount(manualLottoCount);
        countSizeCheck(manualLottoCount);
        this.manualLottoCount = manualLottoCount;

    }

    public void manualCountSetting(String manualLottoCount) {
        if (manualLottoCount == null || manualLottoCount.isEmpty()) {
            manualLottoCount = "0";
        }
        manualCountSetting(parseManualLottoCount(manualLottoCount));
    }

    public long calculateAutoLottoCount() {
        return this.totalCount - this.manualLottoCount;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public long getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PurchaseCount that = (PurchaseCount) o;
        return totalCount == that.totalCount && manualLottoCount == that.manualLottoCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalCount, manualLottoCount);
    }
}
