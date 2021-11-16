package nextstep.lotto.domain;

import java.util.Objects;

import static nextstep.lotto.constance.LottoConstance.LOTTO_PRICE;

public class LottoCount {

    private final Long autoLottoCount;
    private final Long manualLottoCount;

    public LottoCount(PurchaseLottoAmount purchaseLottoAmount) {
        this.autoLottoCount = purchaseLottoAmount.calculateAutoLottoPurchaseCount(LOTTO_PRICE);
        this.manualLottoCount = purchaseLottoAmount.calculateManualLottoPurchaseCount(LOTTO_PRICE);
    }

    public Long getAutoLottoCount() {
        return autoLottoCount;
    }

    public Long getManualLottoCount() {
        return manualLottoCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return Objects.equals(autoLottoCount, that.autoLottoCount) && Objects.equals(manualLottoCount, that.manualLottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoLottoCount, manualLottoCount);
    }
}
