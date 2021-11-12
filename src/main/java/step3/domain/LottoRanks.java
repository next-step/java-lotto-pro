package step3.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoRanks {
    private static final int DECIMAL_POINT = 2;
    private final Amount amount;
    private final Map<LottoRank, CountDown> lottoRanks;

    public LottoRanks(Amount amount, Map<LottoRank, CountDown> lottoRanks) {
        this.amount = amount;
        this.lottoRanks = lottoRanks;
    }

    public List<LottoRankResult> getLottoRankResults() {
        List<LottoRankResult> lottoRankResults = new ArrayList<>();
        for (Map.Entry<LottoRank, CountDown> mapElement : lottoRanks.entrySet()) {
            lottoRankResults.add(new LottoRankResult(mapElement.getKey(), mapElement.getValue().count));
        }
        Collections.sort(lottoRankResults);
        return lottoRankResults;
    }

    public Long totalPrize() {
        long totalPrize = 0L;
        for (Map.Entry<LottoRank, CountDown> mapElement : lottoRanks.entrySet()) {
            long prize = mapElement.getKey().prize;
            totalPrize += (prize * mapElement.getValue().count);
        }

        return totalPrize;
    }

    public BigDecimal getCalculatedYield() {
        return BigDecimal.valueOf(totalPrize())
            .divide(BigDecimal.valueOf(amount.getAmount()))
            .setScale(DECIMAL_POINT, RoundingMode.CEILING);
    }

    public static class Build {
        Map<LottoRank, CountDown> lottoRanks = new HashMap<>();
        Amount amount;

        public Build match(LottoNumbersBundle boughtLottoNumberBundle, WinningLotto winningLotto) {
            for (Map.Entry<LottoRank, CountDown> mapElement : lottoRanks.entrySet()) {
                LottoRank targetLottoRank = mapElement.getKey();
                CountDown countDown = mapElement.getValue();
                int matchCount = boughtLottoNumberBundle.getLottoMatchCountOf(targetLottoRank, winningLotto);
                countDown.incrementOf(matchCount);
            }

            return this;
        }

        public Build setAmount(Amount amount) {
            this.amount = amount;

            return this;
        }

        public Build init() {
            for (LottoRank lottoRank : LottoRank.values()) {
                CountDown matchCountDown = lottoRanks.getOrDefault(
                    lottoRank,
                    new CountDown());

                lottoRanks.put(lottoRank, matchCountDown);
            }
            return this;
        }

        public LottoRanks build() {
            return new LottoRanks(amount, lottoRanks);
        }
    }

    private static class CountDown {
        private int count = 0;

        private CountDown() {
        }

        public void incrementOf(int plusCount) {
            count += plusCount;
        }
    }

    public static class LottoRankResult implements Comparable<LottoRankResult> {
        private final int winningCount;
        private final LottoRank lottoRank;

        public LottoRankResult(LottoRank lottoRank, int winningCount) {
            this.winningCount = winningCount;
            this.lottoRank = lottoRank;
        }

        public int getWinningCount() {
            return winningCount;
        }

        public LottoRank getLottoRank() {
            return lottoRank;
        }

        @Override
        public int compareTo(LottoRankResult lottoRankResult) {
            if (this.lottoRank.prize < lottoRankResult.lottoRank.prize) {
                return -1;
            }
            return 0;
        }
    }
}
