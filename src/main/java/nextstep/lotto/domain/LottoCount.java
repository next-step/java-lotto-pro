package nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static nextstep.lotto.constance.LottoConstance.LOTTO_PRICE;

public class LottoCount {

    private final Integer lottoCount;

    public LottoCount(Integer lottoCount) {
        this.lottoCount = lottoCount;
    }

    public LottoCount(PurchaseLottoAmount purchaseLottoAmount) {
        this.lottoCount = purchaseLottoAmount.calculateLottoPurchaseCount(LOTTO_PRICE);
    }

    public PurchaseLotto purchaseLottoByLottoCount() {

        List<Lotto> purchaseLotto = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumbers = new LottoNumbers();
            Lotto lotto = new Lotto(lottoNumbers);
            purchaseLotto.add(lotto);
        }

        return new PurchaseLotto(purchaseLotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoCount that = (LottoCount) o;
        return Objects.equals(lottoCount, that.lottoCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoCount);
    }
}
