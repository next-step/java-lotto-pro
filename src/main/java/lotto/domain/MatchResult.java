package lotto.domain;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

public class MatchResult {

    private final List<LottoMatch> lottoMatchList;

    public MatchResult(List<LottoMatch> lottoMatchList) {
        this.lottoMatchList = lottoMatchList;
    }

    public List<LottoMatch> getLottoMatchList() {
        return lottoMatchList;
    }

    public HashMap<Rank, Integer> getMatchResult() {
        HashMap<Rank, Integer> rankMap = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + getRankMap(rank));
        }
        return rankMap;
    }

    private int getRankMap(Rank rank) {
        int count = 0;
        for (LottoMatch lottoMatch : lottoMatchList) {
            count += lottoMatch.isMatch(rank) ? 1 : 0;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResult that = (MatchResult) o;
        return Objects.equals(lottoMatchList, that.lottoMatchList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMatchList);
    }
}
