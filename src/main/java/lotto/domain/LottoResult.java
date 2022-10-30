package lotto.domain;

import static lotto.domain.LottoMoney.*;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void addCount(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Integer matches(int count) {
        Rank rank = Rank.valueOf(count, false);
        return result.get(rank);
    }

    public Integer getCount(Rank rank) {
        return result.get(rank);
    }

    public float calculateRateOfReturn() {
        int sumOfCost = PRICE * sumOfCount();
        return (float)sumOfPrizeMoney() / sumOfCost;
    }

    private int sumOfCount() {
        return result.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }

    private int sumOfPrizeMoney() {
        int money = 0;
        for (Rank rank : result.keySet()) {
            money += rank.getSumOfMoney(result.get(rank));
        }
        return money;
    }
}
