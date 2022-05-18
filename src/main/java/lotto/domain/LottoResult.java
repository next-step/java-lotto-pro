package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoResult {
    private List<Ranking> rankingList;

    public LottoResult() {
        rankingList = new ArrayList<>();
    }

    public LottoResult(List<Ranking> rankingList) {
        this.rankingList = rankingList;
    }

    public List<Ranking> findRankings(int matchingCount, boolean matchBonus) {
        return rankingList.stream()
                .filter(getRankingPredicate(matchingCount, matchBonus))
                .collect(Collectors.toList());
    }

    private Predicate<Ranking> getRankingPredicate(int matchingCount, boolean matchBonus) {
        return ranking -> ranking.getMatchingCount() == matchingCount && ranking.isMatchBonus() == matchBonus;
    }

    private void addRankingWhenSame(List<Ranking> result, Ranking ranking, Ranking target) {
        if (ranking.equals(target)) {
            result.add(ranking);
        }
    }

    public List<Ranking> getRankingList() {
        return rankingList;
    }
}
