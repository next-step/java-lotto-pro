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
    private final Map<Integer, Integer> prize = new HashMap<>();
    private final WinningNumber winningNumber;

    public Statistic(WinningNumber winningNumber) {
        initialize();
        this.winningNumber = winningNumber;
    }

    private void initialize() {
        prize.put(Prize.FIRST.getHit(), ZERO);
        prize.put(Prize.SECOND.getHit(), ZERO);
        prize.put(Prize.THIRD.getHit(), ZERO);
        prize.put(Prize.FOURTH.getHit(), ZERO);
    }

    public void countPrize(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            inputCountPrize(winningNumber.countHit(lottoNumber));
        }
    }

    private void inputCountPrize(int hit) {
        if (isHitThree(hit)) {
            addCount(Prize.FOURTH.getHit());
            return;
        }
        if (isHitFour(hit)) {
            addCount(Prize.THIRD.getHit());
            return;
        }
        if (isHitFive(hit)) {
            addCount(Prize.SECOND.getHit());
            return;
        }
        if (isHitSix(hit)) {
            addCount(Prize.FIRST.getHit());
        }
    }

    private boolean isHitThree(int hit) {
        return hit == Prize.FOURTH.getHit();
    }

    private boolean isHitFour(int hit) {
        return hit == Prize.THIRD.getHit();
    }

    private boolean isHitFive(int hit) {
        return hit == Prize.SECOND.getHit();
    }

    private boolean isHitSix(int hit) {
        return hit == Prize.FIRST.getHit();
    }

    private void addCount(int hit) {
        prize.put(hit, prize.get(hit) + 1);
    }

    public int getCountOfFirst() {
        return prize.get(Prize.FIRST.getHit());
    }

    public int getCountOfSecond() {
        return prize.get(Prize.SECOND.getHit());
    }

    public int getCountOfThird() {
        return prize.get(Prize.THIRD.getHit());
    }

    public int getCountOfFourth() {
        return prize.get(Prize.FOURTH.getHit());
    }

    public double calculateTotalEarningsRate(int payMoney) {
        return Math.floor((calculateTotalEarnings() / payMoney) * 100) / 100.0;
    }

    public double calculateTotalEarnings() {
        return Prize.FOURTH.getPrize() * prize.get(Prize.FOURTH.getHit())
                + Prize.THIRD.getPrize() * prize.get(Prize.THIRD.getHit())
                + Prize.SECOND.getPrize() * prize.get(Prize.SECOND.getHit())
                + Prize.FIRST.getPrize() * prize.get(Prize.FIRST.getHit());
    }
}
