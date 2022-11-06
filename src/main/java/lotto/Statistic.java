/*
 * Statistic.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.ZERO;
import static lotto.Rank.FIFTH;
import static lotto.Rank.FIRST;
import static lotto.Rank.FOURTH;
import static lotto.Rank.MISS;
import static lotto.Rank.SECOND;
import static lotto.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Map<Rank, Integer> prize = new HashMap<>();
    private final Lotto winningNumbers;
    private final LottoNumber bonus;

    public Statistic(Lotto winningNumbers, LottoNumber bonus) {
        initialize();
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    private void initialize() {
        prize.put(FIRST, ZERO);
        prize.put(SECOND, ZERO);
        prize.put(THIRD, ZERO);
        prize.put(FOURTH, ZERO);
        prize.put(FIFTH, ZERO);
        prize.put(MISS, ZERO);
    }

    public void countPrize(Lottos lottos) {
        addCount(lottos.getRank(winningNumbers, bonus));
    }

    private void addCount(List<Rank> ranks) {
        for (Rank rank : ranks) {
            prize.put(rank, prize.get(rank) + 1);
        }
    }

    public int getCountOfFirst() {
        return prize.get(FIRST);
    }

    public int getCountOfSecond() {
        return prize.get(SECOND);
    }

    public int getCountOfThird() {
        return prize.get(THIRD);
    }

    public int getCountOfFourth() {
        return prize.get(FOURTH);
    }

    public int getCountOfFifth() {
        return prize.get(FIFTH);
    }

    public double calculateTotalEarningsRate(int payMoney) {
        return calculateTotalEarnings() / payMoney;
    }

    public double calculateTotalEarnings() {
        return FIFTH.getWinningMoney() * prize.get(FIFTH)
                + FOURTH.getWinningMoney() * prize.get(FOURTH)
                + THIRD.getWinningMoney() * prize.get(THIRD)
                + SECOND.getWinningMoney() * prize.get(SECOND)
                + FIRST.getWinningMoney() * prize.get(FIRST);
    }
}
