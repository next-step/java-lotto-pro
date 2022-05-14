package lotto.model;

import java.util.List;
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
}
