package step4.model;

import step3.exception.LottoFormatException;
import step4.constant.ErrorMessageConstant;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<Rank, Integer> lottoWinningStatistics = new LinkedHashMap<>();
    private final Money totalProfit = new Money(0);

    public LottoWinningStatistics(List<Lotto> lottos, Lotto winLotto, LottoNumber bonusLottoNumber) {
        validWinLottoResult(winLotto, bonusLottoNumber);
        initLottoWinningStatistics();
        setLottoWinningStatistics(lottos, winLotto, bonusLottoNumber);
        setTotalProfit();
    }

    private void validWinLottoResult(Lotto winLotto, LottoNumber bonusLottoNumber) {
        if (winLotto.isContains(bonusLottoNumber)) {
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

    private void setLottoWinningStatistics(List<Lotto> lottos, Lotto winLotto, LottoNumber bonusLottoNumber) {
        for (Lotto lotto : lottos) {
            int matchedCount = lotto.getEqualCount(winLotto);
            setLottoWinningStatistic(Rank.valueOf(matchedCount, lotto.isContains(bonusLottoNumber)));
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