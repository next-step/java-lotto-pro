package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchTypeCounter {

    private final HashMap<LottoMatchType, Integer> countMap = new HashMap<>();

    public void add(LottoMatchType lottoMatchType) {
        Integer count = countMap.getOrDefault(lottoMatchType, 0);
        countMap.put(lottoMatchType, count + 1);
    }

    public int get(LottoMatchType lottoMatchType) {
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
