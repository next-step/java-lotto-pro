package nextstep.lotto.domain;

import nextstep.lotto.io.LottoDisplay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static nextstep.lotto.constance.LottoConstance.LOTTO_PRICE;

public class LottoCount {

    private final Long autoLottoCount;
    private final Long manualLottoCount;

    public LottoCount(PurchaseLottoAmount purchaseLottoAmount) {
        this.autoLottoCount = purchaseLottoAmount.calculateAutoLottoPurchaseCount(LOTTO_PRICE);
        this.manualLottoCount = purchaseLottoAmount.calculateManualLottoPurchaseCount(LOTTO_PRICE);
    }

    public PurchaseLotto purchaseLottoByLottoCount() {

        List<Lotto> purchaseLotto = new ArrayList<>();

        for (int i = 0; i < manualLottoCount; i++) {
            Lotto lotto = LottoDisplay.inputManualPurchaseLotto(Boolean.FALSE);
            purchaseLotto.add(lotto);
        }

        for (int i = 0; i < autoLottoCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            purchaseLotto.add(lotto);
        }

        return new PurchaseLotto(purchaseLotto);
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
