package lotto.game;

import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lotto.rank.LottoRank;

public class LottoGameResult {
    private List<LottoRank> rankList;
    public LottoGameResult(List<LottoRank> rankList) {
        this.rankList = Collections.unmodifiableList(rankList);
    }

    public double yield() {
        return totalPrize() / (double) (rankList.size() * LottoGame.LOTTO_PRICE);
    }

    public long totalPrize() {
        return rankList.stream().mapToLong(rank -> rank.getPrize()).sum();
    }

    public Map<LottoRank, Integer> statistics() {
        Map<LottoRank, Integer> statistics = rankList.stream().collect(toMap(lottoRank -> lottoRank
                ,(lottoRank)-> 1,Math::addExact, TreeMap::new));
        statistics.remove(LottoRank.NO_PRIZE);
        return statistics;
    }
}
