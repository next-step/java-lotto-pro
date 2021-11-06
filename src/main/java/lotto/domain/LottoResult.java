package lotto.domain;

import lotto.constant.LottoRank;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private final EnumMap<LottoRank, Integer> lottoRankResult;
    private int totalLottoCount;
    private int totalPrice;

    public LottoResult() {
        this.lottoRankResult = new EnumMap<>(LottoRank.class);
        this.totalLottoCount = 0;
        this.totalPrice = 0;

        initLottoRankResult();
    }

    private void initLottoRankResult() {
        Arrays.stream(LottoRank.values())
                .filter(lottoRank -> !LottoRank.NONE.equals(lottoRank))
                .forEach(lottoRank -> lottoRankResult.put(lottoRank, 0));
    }

    public double computeEarningRate() {
        return  totalPrice / ((double) totalLottoCount * Money.LOTTO_PRICE);
    }

    public void addResult(LottoRank lottoRank) {
        if (!LottoRank.NONE.equals(lottoRank)) {
            lottoRankResult.put(lottoRank, lottoRankResult.get(lottoRank) + 1);
        }

        totalLottoCount++;
        totalPrice += lottoRank.getPrice();
    }

    public String getRankStatus() {
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<LottoRank, Integer> entry : lottoRankResult.entrySet()) {
            String currentStatus = String.format("%d개 일치 (%d원)- %d개%n"
                    , entry.getKey().getMatchingCount()
                    , entry.getKey().getPrice()
                    , entry.getValue());
            sb.append(currentStatus);
        }

        return sb.toString();
    }
}
