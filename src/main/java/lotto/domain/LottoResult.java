package lotto.domain;

import lotto.utils.NumberUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Lotto winningLotto;
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> resultMap = new HashMap<>();

    public LottoResult(Lotto winningLotto, List<Lotto> lottoList) {
        this.winningLotto = winningLotto;
        this.lottoList = lottoList;
        setResultMap();
    }

    private void setResultMap() {
        for (Lotto lotto : lottoList) {
            int matchCount = winningLotto.match(lotto);
            resultMap.put(matchCount, resultMap.getOrDefault(matchCount, 0) + 1);
        }
    }

    public int getResult(int key) {
        return resultMap.get(key) == null ? 0 : resultMap.get(key);
    }

    public double getEarningsRate() {
        int purchaseAmount = Lotto.PRICE * lottoList.size();
        double winningAmount = 0;
        for (Map.Entry<Integer, Integer> entry : resultMap.entrySet()) {
            winningAmount += (LottoPrize.getPrizeMoney(entry.getKey()) * entry.getValue());
        }
        double earningsRate = winningAmount / purchaseAmount;
        return NumberUtils.roundDown(earningsRate, 3);
    }
}
