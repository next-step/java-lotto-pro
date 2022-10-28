package lotto.domain;

import static lotto.domain.Money.DEFAULT_LOTTO_PRICE;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResultStat {

    private static final int INCREASE_SEED = 1;
    private static final int DEFAULT_NUMBER = 0;
    private final Map<LottoRank, Integer> resultBoard = Arrays.stream(LottoRank.values())
            .collect(Collectors.toMap(Function.identity(), i -> DEFAULT_NUMBER));

    public void report(LottoRank rank) {
        resultBoard.put(rank, resultBoard.get(rank) + INCREASE_SEED);
    }

    public int resultByRank(LottoRank rank) {
        return resultBoard.get(rank);
    }

    public double totalProfit() {
        return totalPrice() / (double) totalPurchasePrice();

    }

    private int totalPrice() {
        return resultBoard.keySet()
                .stream()
                .mapToInt(rank -> rank.getWinningPrice() * resultBoard.get(rank))
                .sum();
    }

    private int totalPurchasePrice() {
        int totalPurchaseCount = resultBoard.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return totalPurchaseCount * DEFAULT_LOTTO_PRICE;
    }

}
