package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class LottoStatistic {

    private final Map<Winnings, Integer> statistic;

    public LottoStatistic(Map<Winnings, Integer> statistic) {
        this.statistic = statistic;
    }

    public Map<Winnings, Integer> result(List<Winnings> keys) {
        return keys.stream()
                .collect(toMap(Function.identity(), k -> statistic.getOrDefault(k, 0)));
    }
}
