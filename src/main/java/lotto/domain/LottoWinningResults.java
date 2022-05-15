package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.enums.LottoRank;

public class LottoWinningResults {

    private final List<LottoRank> prizedRanks;

    private LottoWinningResults(List<LottoRank> resultRanks) {
        this.prizedRanks = pickPrizedRanks(resultRanks);;
    }

    private List<LottoRank> pickPrizedRanks(List<LottoRank> resultRanks) {
        return resultRanks.stream().
                filter(r -> r != LottoRank.MISS).
                collect(Collectors.toList());
    }

    public static LottoWinningResults from(List<LottoRank> resultRanks) {
        return new LottoWinningResults(resultRanks);
    }

    public double prizedMoney() {
        double result = 0;
        for (LottoRank prizedRank : prizedRanks) {
            result += prizedRank.getWinningMoney();
        }
        return result;
    }

    public int winingRankCount(LottoRank lottoRank) {
        return (int) prizedRanks.stream().
                filter(result -> result.equals(lottoRank)).
                count();
    }

    public double profitRate(Money purchaseMoney) {
        return prizedMoney() / purchaseMoney.getMoney();
    }
}
