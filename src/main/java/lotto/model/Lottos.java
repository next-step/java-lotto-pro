package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoRoleConst;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos() {
        this.lottoList = new ArrayList<>();
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public int lottoCount() {
        return lottoList.size();
    }
    private int purchaseMoney(){
        return lottoCount() * LottoRoleConst.LOTTO_PRICE;
    }

    public double calcProfitRate(int totalWinningMount) {
        return (double) totalWinningMount / purchaseMoney();
    }
}
