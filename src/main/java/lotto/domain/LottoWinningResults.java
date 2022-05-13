package lotto.domain;

import java.util.List;
import lotto.enums.LottoRank;

public class LottoWinningResults {

    private final List<LottoRank> results;

    private LottoWinningResults(List<LottoRank> resultRanks) {
        this.results = resultRanks;
    }

    public static LottoWinningResults from(List<LottoRank> resultRanks) {
        return new LottoWinningResults(resultRanks);
    }

    public double prizedMoney() {
        double result = 0;
        for (LottoRank lottoRank : results) {
            result += lottoRank.getWinningMoney();
        }
        return result;
    }

    public int winingRankCount(LottoRank lottoRank) {
        return (int) results.stream().
                filter(result -> result.equals(lottoRank)).
                count();
    }
}
