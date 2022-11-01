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
    private final Map<Integer, Integer> rank = new HashMap<>();
    private final LottoNumber winningNumber;

    public Statistic(LottoNumber winningNumber) {
        initialize();
        this.winningNumber = winningNumber;
    }

    private void initialize() {
        rank.put(Rank.FIRST.getCountOfMatch(), ZERO);
        rank.put(Rank.SECOND.getCountOfMatch(), ZERO);
        rank.put(Rank.THIRD.getCountOfMatch(), ZERO);
        rank.put(Rank.FOURTH.getCountOfMatch(), ZERO);
    }

    public void countPrize(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            inputCountPrize(winningNumber.countHit(lottoNumber));
        }
    }

    private void inputCountPrize(int hit) {
        if (rank.containsKey(hit)) {
            addCount(hit);
        }
    }

    private void addCount(int hit) {
        rank.put(hit, rank.get(hit) + 1);
    }

    public int getCountOfFirst() {
        return rank.get(Rank.FIRST.getCountOfMatch());
    }

    public int getCountOfSecond() {
        return rank.get(Rank.SECOND.getCountOfMatch());
    }

    public int getCountOfThird() {
        return rank.get(Rank.THIRD.getCountOfMatch());
    }

    public int getCountOfFourth() {
        return rank.get(Rank.FOURTH.getCountOfMatch());
    }

    public double calculateTotalEarningsRate(int payMoney) {
        return Math.floor((calculateTotalEarnings() / payMoney) * 100) / 100.0;
    }

    public double calculateTotalEarnings() {
        return Rank.FOURTH.getWinningMoney() * rank.get(Rank.FOURTH.getCountOfMatch())
                + Rank.THIRD.getWinningMoney() * rank.get(Rank.THIRD.getCountOfMatch())
                + Rank.SECOND.getWinningMoney() * rank.get(Rank.SECOND.getCountOfMatch())
                + Rank.FIRST.getWinningMoney() * rank.get(Rank.FIRST.getCountOfMatch());
    }
}
