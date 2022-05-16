package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private List<Ranking> rankingList;

    public LottoResult() {
        rankingList = new ArrayList<>();
    }

    public LottoResult(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    public List<Ranking> findRankings(int matchingCount) {
        List<Ranking> result = new ArrayList<>();
        Ranking target = Ranking.findRank(matchingCount, false);
        for (Ranking ranking : rankingList) {
            addRankingWhenSame(result, ranking, target);
        }
        return result;
    }

    private void addRankingWhenSame(List<Ranking> result, Ranking ranking, Ranking target) {
        if (ranking.equals(target)) {
            result.add(ranking);
        }
    }

    public BigDecimal calculateWinningMoney() {
        return rankingList.stream()
                .mapToInt(Ranking::getReward)
                .mapToObj(BigDecimal::new)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal calculateWinningProfit(Money money) {
        BigDecimal winningMoney = calculateWinningMoney();
        BigDecimal divisor = new BigDecimal(money.getMoney());
        return winningMoney.divide(divisor).setScale(2, RoundingMode.HALF_UP);
    }
}
