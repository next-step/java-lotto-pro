package step4.model;

import step3.exception.LottoFormatException;
import step4.constant.ErrorMessageConstant;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<Rank, Integer> lottoWinningStatistics = new LinkedHashMap<>();
    private final Money totalProfit = new Money(0);

    public LottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult, LottoNumber bonusLottoNumber) {
        validWinLottoResult(winLottoResult, bonusLottoNumber);
        initLottoWinningStatistics();
        setLottoWinningStatistics(lottoResults, winLottoResult, bonusLottoNumber);
        setTotalProfit();
    }

    private void validWinLottoResult(LottoResult winLottoResult, LottoNumber bonusLottoNumber) {
        if (winLottoResult.isContains(bonusLottoNumber)) {
            throw new LottoFormatException(ErrorMessageConstant.BONUS_NUMBER_IN_LOTTO_WIN_RESULT);
        }
    }

    private void initLottoWinningStatistics() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        for (Rank rank : ranks) {
            this.lottoWinningStatistics.put(rank, 0);
        }
    }

    private void setLottoWinningStatistics(List<LottoResult> lottoResults, LottoResult winLottoResult, LottoNumber bonusLottoNumber) {
        for (LottoResult lottoResult : lottoResults) {
            int matchedCount = lottoResult.getEqualCount(winLottoResult);
            setLottoWinningStatistic(Rank.valueOf(matchedCount, lottoResult.isContains(bonusLottoNumber)));
        }
    }

    private void setLottoWinningStatistic(Rank rank) {
        this.lottoWinningStatistics.put(rank, lottoWinningStatistics.get(rank) + 1);
    }

    public Map<Rank, Integer> getLottoWinningStatistics() {
        return lottoWinningStatistics;
    }

    private void setTotalProfit() {
        for (Rank rank : Rank.values()) {
            totalProfit.plus(new Money(rank.getProfitTotalMoney(lottoWinningStatistics.get(rank))));
        }
    }

    public double getTotalProfitPercent(Money money) {
        return totalProfit.getPercent(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoWinningStatistics that = (LottoWinningStatistics) o;
        return Objects.equals(lottoWinningStatistics, that.lottoWinningStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoWinningStatistics);
    }
}