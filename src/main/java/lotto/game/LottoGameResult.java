package lotto.game;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
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

    public Map<LottoRank, Long> statistics() {
        Map<LottoRank, Long> statistics = rankList.stream().filter(rank -> rank != LottoRank.NO_PRIZE)
                .collect(groupingBy(Function.identity(), TreeMap::new, counting()));
        return statistics;
    }
}
