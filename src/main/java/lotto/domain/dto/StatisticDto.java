package lotto.domain.dto;

import lotto.domain.enums.Rank;

import java.util.HashMap;
import java.util.Map;

public class StatisticDto {
    private static final int DEFAULT_VALUE = 0;
    private static final int INCREASE_VALUE = 1;

    private final Map<Integer ,Integer> statistics = new HashMap<>();

    private StatisticDto() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank.getMatchCount(), DEFAULT_VALUE);
        }
    }

    public static StatisticDto create() {
        return new StatisticDto();
    }

    public void add(int matchCount) {
        if (Rank.isBiggerThanMinimum(matchCount)) {
            statistics.merge(matchCount, INCREASE_VALUE, Integer::sum);
        }
    }

    public int getCount(int match) {
        return statistics.get(match);
    }
}
