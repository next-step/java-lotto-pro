package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static lotto.domain.WinningMoneyType.find;

public class Statistics {
    public static final int SUM_INIT = 0;
    private final Lottos lottos;
    private final WinningNumber winningNumber;

    public Statistics(Lottos lottos, WinningNumber winningNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
    }

    public Map<Integer, Lottos> lottosMap() {
        return this.lottos.matchLottos(this.winningNumber);
    }

    public double returnRate() {
        return BigDecimal.valueOf(sum()).divide(BigDecimal.valueOf((int) this.lottos.size() * 1000), 2, RoundingMode.HALF_UP).doubleValue();
    }

    public int sum() {
        int sum = SUM_INIT;
        Map<Integer, Lottos> map = this.lottos.matchLottos(this.winningNumber);
        for (Integer count : map.keySet()) {
            sum += find(count).getMoney() * map.get(count).size();
        }
        return sum;
    }
}
