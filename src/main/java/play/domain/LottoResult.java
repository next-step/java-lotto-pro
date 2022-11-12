
package play.domain;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
    public static final int LOTTO_PRICE = 1000;
    private static final int DEFAULT_VALUE = 0;
    private static final BigDecimal VALUE_1 = BigDecimal.valueOf(1.0);
    private static final int NUM_1 = 1;
    private static final int ZERO = 0;

    private final Map<Rank, Integer> resultMap;
    private int lottoCount;

    public LottoResult() {
        resultMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            resultMap.put(rank, 0);
        }
        lottoCount = ZERO;
    }

    public void calculateLottoResult(Lottos lottoList, PrizeNumbers prizeNumbers) {
        for (Lotto lotto : lottoList.getLottoList()) {
            calculateLottoMatch(lotto, prizeNumbers);
            lottoCount++;
        }
    }

    private void calculateLottoMatch(Lotto lotto, PrizeNumbers prizeNumbers) {
        int matchingCount = lotto.getMatchingCount(prizeNumbers.getLotto());
        Rank rank = Rank.getRank(matchingCount);
        resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
    }

    public boolean isValidNothing(Rank rank) {
        return rank == Rank.NOTHING;
    }

    private BigDecimal calculateRate() {
        int prizeMoney = DEFAULT_VALUE;

        for (Rank rank : resultMap.keySet()) {
            prizeMoney += (rank.getMoney() * resultMap.get(rank));
        }
        return new BigDecimal(prizeMoney / (lottoCount * LOTTO_PRICE));
    }

    public String convertYieldToString() {
        StringBuilder stringBuilder = new StringBuilder();
        BigDecimal rate = calculateRate().setScale(NUM_1);
        stringBuilder.append("총 수익률은 ").append(rate).append("입니다.");
        if (rate.compareTo(VALUE_1) < ZERO) {
            stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
        }
        return stringBuilder.toString();
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }

}
