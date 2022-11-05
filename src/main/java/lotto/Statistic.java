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
    private final LottoNumbers winningNumbers;

    public Statistic(LottoNumbers winningNumbers) {
        initialize();
        this.winningNumbers = winningNumbers;
    }

    private void initialize() {
        prize.put(FIRST, ZERO);
        prize.put(SECOND, ZERO);
        prize.put(THIRD, ZERO);
        prize.put(FOURTH, ZERO);
        prize.put(FIFTH, ZERO);
        prize.put(MISS, ZERO);
    }

    public void countPrize(PurchaseLottoNumbers purchaseLottoNumbers, LottoNumber bonus) {
        addCount(purchaseLottoNumbers.getRank(winningNumbers, bonus));
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
        return Math.floor((calculateTotalEarnings() / payMoney) * 100) / 100.0;
    }

    public double calculateTotalEarnings() {
        return FIFTH.getWinningMoney() * prize.get(FIFTH)
                + FOURTH.getWinningMoney() * prize.get(FOURTH)
                + THIRD.getWinningMoney() * prize.get(THIRD)
                + SECOND.getWinningMoney() * prize.get(SECOND)
                + FIRST.getWinningMoney() * prize.get(FIRST);
    }
}
