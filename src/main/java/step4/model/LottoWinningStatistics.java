package step4.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoWinningStatistics {
    private static final Map<Rank, Integer> lottoWinningStatistics;

    static {
        lottoWinningStatistics = initLottoWinningStatistics();
    }

    private final Money totalProfit = new Money(0);

    public LottoWinningStatistics(List<Lotto> lottos, Lotto winLotto, LottoNumber bonusLottoNumber) {
        this(lottos, new WinningLotto(winLotto, bonusLottoNumber));
    }

    public LottoWinningStatistics(List<Lotto> lottos, WinningLotto winLotto) {
        this(new Lottos(lottos), winLotto);
    }

    public LottoWinningStatistics(Lottos lottos, WinningLotto winLotto) {
        setLottoWinningStatistics(lottos, winLotto);
        setTotalProfit();
    }

    private static Map<Rank, Integer> initLottoWinningStatistics() {
        return Arrays.stream(Rank.values())
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toMap(rank -> rank, rank -> 0, (r1, r2) -> r1, LinkedHashMap::new));
    }

    private void setLottoWinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        for (Rank rank : lottoWinningStatistics.keySet()) {
            setLottoWinningStatistic(lottos, winningLotto, rank);
        }
    }

    private void setLottoWinningStatistic(Lottos lottos, WinningLotto winningLotto, Rank rank) {
        lottoWinningStatistics.put(rank, lottos.matchCountAboutRank(winningLotto, rank));
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
        return Objects.equals(totalProfit, that.totalProfit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalProfit);
    }
}