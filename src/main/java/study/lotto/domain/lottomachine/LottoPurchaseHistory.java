package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import study.lotto.domain.Lottos;

public class LottoPurchaseHistory {
    private final Lottos lottos;
    private final BigDecimal totalCost;

    public LottoPurchaseHistory(Lottos lottos, BigDecimal totalCost) {
        this.lottos = lottos;
        this.totalCost = totalCost;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }
}
