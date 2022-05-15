package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoRoleConst;

public class Lottos {

    private final List<Lotto> lottoz;

    public Lottos(List<Lotto> lottoz) {
        this.lottoz = lottoz;
    }

    public List<Lotto> getLottoz() {
        return lottoz;
    }

    public int lottoCount() {
        return lottoz.size();
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
        return Objects.equals(this.lottoz, lottos.lottoz);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoz);
    }
}
