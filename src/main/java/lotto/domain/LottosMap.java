package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoMoney.LOTTO_MINIMUM_PRICE;
import static lotto.domain.Lottos.DIGIT;

public class LottosMap {

    private final Map<LottoType, Lottos> lottos = new HashMap<>();

    public void put(LottoType type, Lottos lottos) {
        this.lottos.put(type, lottos);
    }

    public Lottos getLottos(LottoType type) {
        return this.lottos.get(type);
    }

    public int size(LottoType type) {
        return this.lottos.get(type).getLottos().size();
    }

    public int matchLottoCount(WinningMoney winningMoney, WinningLotto winningLotto) {
        int count = 0;
        for (Lottos lottos : this.lottos.values()) {
            count += lottos.matchLottoCount(winningMoney, winningLotto);
        }
        return count;
    }

    public double returnRate(WinningLotto winningLotto) {
        return sum(winningLotto)
                .divide(BigDecimal.valueOf((long) size() * LOTTO_MINIMUM_PRICE), DIGIT, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private BigDecimal sum(WinningLotto winningLotto) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Lottos lottos : this.lottos.values()) {
            sum = sum.add(BigDecimal.valueOf(lottos.sum(winningLotto)));
        }
        return sum;
    }

    private int size() {
        int size = 0;
        for (Lottos lottos : this.lottos.values()) {
            size += lottos.size();
        }
        return size;
    }
}
