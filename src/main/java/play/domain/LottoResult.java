
package play.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    public static final int LOTTO_PRICE = 1000;
    private static final int DEFAULT_VALUE = 0;
    private static final int COUNT_VALUE = 1;
    private static final double MATH_ROUND_VALUE = 100d;


    private final HashMap<Rank, Integer> resultMap;
    private final Lottos lottoList;
    private final PrizeNumbers prizeNumbers;


    public LottoResult(Lottos lottoList, PrizeNumbers prizeNumbers) {
        resultMap = new HashMap<Rank, Integer>();
        this.lottoList = lottoList;
        this.prizeNumbers = prizeNumbers;
        calculateLottoResult();
    }

    private void calculateLottoResult() {
        for (Lotto lotto : lottoList.getLottoList()) {
            calculateLottoMatch(lotto);
        }
    }

    private void calculateLottoMatch(Lotto lotto) {
        int matchingCount = lotto.getMatchingCount(prizeNumbers.getLotto());

        Rank rank = Rank.getRank(matchingCount);

        if (resultMap.containsKey(rank)) {
            int value = resultMap.get(rank);

            value++;

            resultMap.put(rank, value);

            return;
        }

        resultMap.put(rank, 1);
    }

    public List<String> convertResultMapToString() {

        List<String> rankList = new ArrayList<>();

        for (Map.Entry<Rank, Integer> rankEntry : resultMap.entrySet()) {
            validNothing(rankList, rankEntry);
        }
        Collections.sort(rankList);

        return rankList;
    }

    private String stringBuilderAppend(Map.Entry<Rank, Integer> rankEntry) {
        Rank rank = rankEntry.getKey();
        return String.format("%d개 일치 (%d원)- %d개", rank.containsCount(), rank.getMoney(), rankEntry.getValue());
    }

    private void validNothing(List<String> rankStringList, Map.Entry<Rank, Integer> rankEntry) {
        if (rankEntry.getKey() != Rank.NOTHING) {
            rankStringList.add(stringBuilderAppend(rankEntry));
        }
    }

    private double calculateRate() {
        int prizeMoney = DEFAULT_VALUE;

        for (Rank rank : resultMap.keySet()) {
            int money = rank.getMoney();
            int value = resultMap.get(rank);

            prizeMoney += money * value;
        }

        return prizeMoney / (lottoList.getLottoList().size() * LOTTO_PRICE);
    }

    public String convertYieldToString() {
        StringBuilder stringBuilder = new StringBuilder();
        double rate = (Math.round((calculateRate() * MATH_ROUND_VALUE)) / MATH_ROUND_VALUE);
        stringBuilder.append("총 수익률은 ").append(rate).append("입니다.");
        if (rate < COUNT_VALUE) {
            stringBuilder.append("(기준이 1이기 떄문에 결과적으로 손해라는 의미임)");
        }
        return stringBuilder.toString();
    }

}
