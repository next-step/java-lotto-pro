package lotto.dto;

import java.util.Map;
import lotto.rank.LottoRank;

/**
 * 당첨 통계와 수익률을 같이 전달하기 위한 DTO 클래스
 */
public class LottoGameResultDTO {
    private Map<LottoRank,Integer> statistics;
    private double yield;

    public LottoGameResultDTO(Map<LottoRank, Integer> statistics, double yield) {
        this.statistics = statistics;
        this.yield = yield;
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }

    public double getYield() {
        return yield;
    }
}
