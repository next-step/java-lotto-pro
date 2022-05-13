package study.lotto.domain.lottomachine;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import study.lotto.domain.Lotto;
import study.lotto.domain.Lottos;

public class LottoPurchaseHistory {
    private final Lottos lottos;
    private final BigDecimal totalPrice;

    public LottoPurchaseHistory() {
        this(new Lottos(new ArrayList<>()), BigDecimal.ZERO);
    }

    public LottoPurchaseHistory(List<Lotto> lottoList, BigDecimal totalPrice) {
        this(new Lottos(lottoList), totalPrice);
    }

    public LottoPurchaseHistory(Lottos lottos, BigDecimal totalPrice) {
        this.lottos = lottos;
        this.totalPrice = totalPrice;
    }

    public Lottos getLottos() {
        return lottos;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}
