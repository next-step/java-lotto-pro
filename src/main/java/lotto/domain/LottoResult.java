package lotto.domain;

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
        Ranking target = Ranking.findRank(matchingCount);
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

    public int calculateWinningMoney() {
        int winningMoney = 0;
        for (Ranking ranking : rankingList) {
            winningMoney += ranking.getReward();
        }
        return winningMoney;
    }
}
