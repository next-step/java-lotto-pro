package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.enums.LottoRank;

public class LottoWinningResults {

    private static final int INIT_COUNT_VALUE = 0;

    private final Map<LottoRank, Integer> resultMap = new HashMap<>();

    private LottoWinningResults(List<LottoRank> resultRanks) {
        initResultMap();
        makeResultsOnMap(resultRanks);
    }

    private void makeResultsOnMap(List<LottoRank> resultRanks) {
        resultRanks.stream().
                filter(rank -> rank.isPrized(rank)).
                forEach(rank ->
                        this.resultMap.put(rank, this.resultMap.get(rank) + 1));
    }

    private void initResultMap() {
        LottoRank.getPrizedRanks().stream().
                forEach(r -> resultMap.put(r, INIT_COUNT_VALUE));
    }

    public static LottoWinningResults from(List<LottoRank> resultRanks) {
        return new LottoWinningResults(resultRanks);
    }

    public double prizedMoney() {
        double result = 0;
        for (LottoRank lottoRank : resultMap.keySet()) {
            result += lottoRank.getWinningMoney() * resultMap.get(lottoRank);
        }
        return result;
    }

    public int winingRankCount(LottoRank lottoRank) {
        return resultMap.get(lottoRank);
    }
}
