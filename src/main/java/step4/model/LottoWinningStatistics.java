package step4.model;

import java.util.*;

public class LottoWinningStatistics {
    private final Map<Rank, Integer> lottoWinningStatistics = new LinkedHashMap<>();
    private final Money totalProfit = new Money(0);

    public LottoWinningStatistics(List<Lotto> lottos, Lotto winLotto, LottoNumber bonusLottoNumber) {
        this(lottos, new WinningLotto(winLotto, bonusLottoNumber));
    }

    public LottoWinningStatistics(List<Lotto> lottos, WinningLotto winLotto) {
        initLottoWinningStatistics();
        setLottoWinningStatistics(lottos, winLotto);
        setTotalProfit();
    }

    private void initLottoWinningStatistics() {
        List<Rank> ranks = Arrays.asList(Rank.values());
        Collections.reverse(ranks);
        for (Rank rank : ranks) {
            this.lottoWinningStatistics.put(rank, 0);
        }
    }

    private void setLottoWinningStatistics(List<Lotto> lottos, WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            setLottoWinningStatistic(winningLotto.match(lotto));
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