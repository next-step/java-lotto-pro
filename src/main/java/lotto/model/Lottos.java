package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoRoleConst;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int lottoCount() {
        return lottos.size();
    }

    private int purchaseMoney() {
        return lottoCount() * LottoRoleConst.LOTTO_PRICE;
    }

    public double calcProfitRate(int totalWinningMount) {
        return (double) totalWinningMount / purchaseMoney();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos = (Lottos) o;
        return Objects.equals(this.lottos, lottos.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
