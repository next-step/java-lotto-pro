/*
 * Statistic.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Constant.ZERO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final Map<Rank, Integer> prize = new HashMap<>();
    private final LottoNumber winningNumber;

    public Statistic(LottoNumber winningNumber) {
        initialize();
        this.winningNumber = winningNumber;
    }

    private void initialize() {
        prize.put(Rank.FIRST, ZERO);
        prize.put(Rank.SECOND, ZERO);
        prize.put(Rank.THIRD, ZERO);
        prize.put(Rank.FOURTH, ZERO);
        prize.put(Rank.FIFTH, ZERO);
        prize.put(Rank.MISS, ZERO);
    }

    public void countPrize(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            inputCountPrize(winningNumber.countHit(lottoNumber), winningNumber.containsBonus(lottoNumber));
        }
    }

    private void inputCountPrize(int hit, boolean matchBonus) {
        if (prize.containsKey(Rank.valueOf(hit, matchBonus))) {
            addCount(Rank.valueOf(hit, matchBonus));
        }
    }

    private void addCount(Rank rank) {
        prize.put(rank, prize.get(rank) + 1);
    }

    public int getCountOfFirst() {
        return prize.get(Rank.FIRST);
    }

    public int getCountOfSecond() {
        return prize.get(Rank.SECOND);
    }

    public int getCountOfThird() {
        return prize.get(Rank.THIRD);
    }

    public int getCountOfFourth() {
        return prize.get(Rank.FOURTH);
    }

    public int getCountOfFifth() {
        return prize.get(Rank.FIFTH);
    }

    public double calculateTotalEarningsRate(int payMoney) {
        return Math.floor((calculateTotalEarnings() / payMoney) * 100) / 100.0;
    }

    public double calculateTotalEarnings() {
        return Rank.FIFTH.getWinningMoney() * prize.get(Rank.FIFTH)
                + Rank.FOURTH.getWinningMoney() * prize.get(Rank.FOURTH)
                + Rank.THIRD.getWinningMoney() * prize.get(Rank.THIRD)
                + Rank.SECOND.getWinningMoney() * prize.get(Rank.SECOND)
                + Rank.FIRST.getWinningMoney() * prize.get(Rank.FIRST);
    }
}
