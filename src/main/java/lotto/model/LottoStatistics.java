package lotto.model;

import java.util.Map;

public class LottoStatistics {
    private final Map<LottoRanking, Integer> lottoStatistics;

    public LottoStatistics(Map<LottoRanking, Integer> lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public int get(LottoRanking lottoRanking) {
        return lottoStatistics.getOrDefault(lottoRanking, 0);
    }
}
