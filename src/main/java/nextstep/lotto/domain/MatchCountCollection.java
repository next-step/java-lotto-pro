package nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatchCountCollection implements Iterable<MatchCount> {

    public static final Integer WINNER_LOTTO_MIN_MATCHING_COUNT = 3;
    private final List<MatchCount> matchCounts;

    public MatchCountCollection(List<MatchCount> matchCounts) {
        this.matchCounts = matchCounts;
    }

    private MatchCountCollection(Map<Integer, MatchCount> matchCountMap) {

        List<MatchCount> matchCounts = new ArrayList<>();
        for (Map.Entry<Integer, MatchCount> entry : matchCountMap.entrySet()) {
            Integer key = entry.getKey();
            MatchCount value = entry.getValue();
            loadGreaterThanMinMatchingCount(matchCounts, key, value);
        }

        Collections.sort(matchCounts);
        this.matchCounts = matchCounts;
    }

    private void loadGreaterThanMinMatchingCount(List<MatchCount> matchCounts, Integer key, MatchCount value) {
        if (key >= WINNER_LOTTO_MIN_MATCHING_COUNT) {
            matchCounts.add(value);
        }
    }

    public static MatchCountCollection matchPurchaseLottoWithWinningLotto(PurchaseLotto purchaseLotto, WinningLotto winningLotto) {

        Map<Integer, MatchCount> matchCountMap = new HashMap<>();
        for (Lotto eachLotto : purchaseLotto) {
            Integer calculatedCount = winningLotto.matchWithPurchaseLottoCount(eachLotto);

            MatchCount cached = matchCountMap.get(calculatedCount);
            loadMatchCountMap(matchCountMap, calculatedCount, cached);
        }

        return new MatchCountCollection(matchCountMap);
    }

    private static void loadMatchCountMap(Map<Integer, MatchCount> matchCountMap, Integer key, MatchCount value) {

        if (Objects.isNull(value)) {
            matchCountMap.put(key, new MatchCount(key, 0));
            return;
        }

        matchCountMap.put(key, value.addToMatchCount());
    }

    @Override
    public Iterator<MatchCount> iterator() {
        return matchCounts.iterator();
    }
}
