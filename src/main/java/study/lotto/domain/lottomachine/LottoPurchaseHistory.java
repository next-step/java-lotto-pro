package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import study.lotto.domain.Lottos;

public class LottoPurchaseHistory {
    private final Lottos lottos;
    private final LottoCount manualCount;
    private final BigDecimal totalCost;

    public LottoPurchaseHistory(Lottos lottos, LottoCount manualCount, BigDecimal totalCost) {
        this.lottos = lottos;
        this.manualCount = manualCount;
        this.totalCost = totalCost;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public LottoCount getManualCount() {
        return manualCount;
    }

    public LottoCount getAutomaticLottoCount() {
        LottoCount count = lottos.count();
        return count.subtract(manualCount);
    }
}
