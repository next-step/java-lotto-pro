package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoMoney.LOTTO_MINIMUM_PRICE;
import static lotto.domain.WinningMoney.find;

public class Lottos {
    public static final int INIT_SUM = 0;
    public static final int DIGIT = 2;
    private final List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public void add(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public double returnRate(WinningLotto winningLotto) {
        return BigDecimal.valueOf(sum(winningLotto))
                .divide(BigDecimal.valueOf((int) this.lottos.size() * LOTTO_MINIMUM_PRICE), DIGIT, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public int sum(WinningLotto winningLotto) {
        int sum = INIT_SUM;
        for (Lotto lotto : this.lottos) {
            sum += find(lotto.matchCount(winningLotto), lotto.isMatchBonusBall(winningLotto)).getMoney();
        }
        return sum;
    }

    public int size() {
        return this.lottos.size();
    }

    public int matchLottoCount(WinningMoney winningMoney, WinningLotto winningLotto) {
        return (int) this.lottos
                .stream()
                .filter(lotto -> find(lotto.matchCount(winningLotto), lotto.isMatchBonusBall(winningLotto)) == winningMoney)
                .count();
    }
}
