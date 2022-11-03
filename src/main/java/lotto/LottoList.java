package lotto;

import java.util.*;

public class LottoList {

    private final HashMap<LottoMatchType, Integer> countMap = new HashMap<>();
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

    public void match(Lotto winLotto, BonusLottoNumber bonusLottoNumber) {
        for (Lotto lotto : lottoList) {
            LottoMatchType lottoMatchType = lotto.match(winLotto);
            lottoMatchType = lottoMatchType.promotionBonusBall(bonusLottoNumber.match(lotto));
            Integer count = countMap.getOrDefault(lottoMatchType, 0);
            countMap.put(lottoMatchType, ++count);
        }
    }

    public Integer getLottoMatchTypeCount(LottoMatchType lottoMatchType) {
        return countMap.getOrDefault(lottoMatchType, 0);
    }

    public int getSumProfit() {
        int sumProfit = 0;
        for (Map.Entry<LottoMatchType, Integer> entry : countMap.entrySet()) {
            LottoMatchType lottoMatchType = entry.getKey();
            Integer count = entry.getValue();
            sumProfit += lottoMatchType.multiply(count);
        }
        return sumProfit;
    }
}
