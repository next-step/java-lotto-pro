package lotto.domain;

import static lotto.domain.Lotto.*;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Prize, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
        for (Prize prize : Prize.values()) {
            result.put(prize, 0);
        }
    }

    public void putPrize(Prize prize) {
        result.put(prize, result.get(prize) + 1);
    }

    public Integer matches(int count) {
        Prize prize = Prize.of(count);
        return result.get(prize);
    }

    public Integer getCount(Prize prize) {
        return result.get(prize);
    }

    public float calculateRateOfReturn() {
        int sumOfCost = PRICE * sumOfCount();
        return (float)sumOfPrizeMoney() / sumOfCost;
    }

    private int sumOfPrizeMoney() {
        int money = 0;
        for (Map.Entry<Prize, Integer> entry : result.entrySet()) {
            money += entry.getKey().getSumOfMoney(entry.getValue());
        }
        return money;
    }

    private int sumOfCount() {
        return result.values().stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
