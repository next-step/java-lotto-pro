package lotto.domain;

import lotto.constant.LottoRank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private final EnumMap<LottoRank, Integer> lottoRankResult;

    public LottoResult() {
        this.lottoRankResult = new EnumMap<>(LottoRank.class);

        initLottoRankResult();
    }

    private void initLottoRankResult() {
        Arrays.stream(LottoRank.values())
                .forEach(lottoRank -> lottoRankResult.put(lottoRank, 0));
    }

    public double computeEarningRate() {
        long totalPrice = this.getTotalPrice();
        int totalLottoCount = this.getTotalLottoCount();

        if (totalLottoCount == 0) {
            return 0;
        }

        return totalPrice / ((double) totalLottoCount * Money.LOTTO_PRICE);
    }

    private long getTotalPrice() {
        long totalPrice = 0;

        for (Map.Entry<LottoRank, Integer> lottoRankResultEntry : lottoRankResult.entrySet()) {
            totalPrice += (long) lottoRankResultEntry.getKey().getPrice() * lottoRankResultEntry.getValue();
        }

        return totalPrice;
    }

    private int getTotalLottoCount() {
        int totalLottoCount = 0;

        for (Integer lottoRankResultValue : lottoRankResult.values()) {
            totalLottoCount += lottoRankResultValue;
        }

        return totalLottoCount;
    }

    public void addResult(LottoRank lottoRank) {
        lottoRankResult.put(lottoRank, lottoRankResult.get(lottoRank) + 1);
    }

    public Map<LottoRank, Integer> getRankStatus() {
        EnumMap<LottoRank, Integer> rankStatus = new EnumMap<>(LottoRank.class);
        rankStatus.putAll(lottoRankResult);

        return rankStatus;
    }
}
