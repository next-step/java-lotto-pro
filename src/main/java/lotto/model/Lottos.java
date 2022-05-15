package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.constant.LottoRoleConst;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int lottoCount() {
        return lottoList.size();
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
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
