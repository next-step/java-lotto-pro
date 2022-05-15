package lotto.auto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LottoPurchase {
    private List<LottoNumbers> lottoNumbers;

    public int issuedLottoCount() {
        if (isNullLottoNumbers()) {
            return 0;
        }
        return this.lottoNumbers.size();
    }

    private boolean isNullLottoNumbers() {
        return !Optional.ofNullable(this.lottoNumbers).isPresent();
    }

    public LottoPurchase(int purchaseCount) {
        this.lottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            this.lottoNumbers.add(new LottoNumbers());
        }
    }
}
