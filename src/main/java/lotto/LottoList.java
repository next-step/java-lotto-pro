package lotto;

import java.util.*;

public class LottoList {

    private final List<Lotto> lottoList = new ArrayList<>();

    public void add(Lotto lotto) {
        add(Collections.singletonList(lotto));
    }

    public void add(List<Lotto> lotto) {
        this.lottoList.addAll(lotto);
    }

    public List<Lotto> get() {
        return this.lottoList;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : lottoList) {
            builder.append(lotto.toString())
                .append("\n");
        }
        return builder.toString();
    }

    public List<LottoMatchType> match(Lotto winLotto, BonusLottoNumber bonusLottoNumber) {
        List<LottoMatchType> lottoMatchTypeList = new ArrayList<>();
        for (Lotto lotto : lottoList) {
            LottoMatchType lottoMatchType = lotto.match(winLotto);
            lottoMatchTypeList.add(lottoMatchType.promotionBonusBall(bonusLottoNumber.match(lotto)));
        }
        return lottoMatchTypeList;
    }
}
