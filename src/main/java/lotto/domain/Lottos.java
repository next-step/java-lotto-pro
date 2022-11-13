package lotto.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public void addAll(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public BigDecimal sum(WinningLotto winningLotto) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Lotto lotto : this.lottos) {
            sum = sum.add(BigDecimal.valueOf(find(lotto.matchCount(winningLotto), lotto.isMatchBonusBall(winningLotto)).getMoney()));
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
