package lotto.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult() {
        result = Arrays.stream(Rank.values())
                .collect(Collectors.toMap(Function.identity(), i -> 0));
    }

    public void add(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public int getRankCount(Rank rank) {
        return result.get(rank);
    }

    public long getAllPrize() {
        return result.keySet()
                .stream()
                .mapToInt(rank -> rank.getPrize() * result.get(rank))
                .sum();
    }

    public double getReturnRate() {
        int allLottoCount = result.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return (double)getAllPrize() / (allLottoCount * Lotto.LOTTO_PRICE);
    }
}
