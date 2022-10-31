/*
 * Prize.java
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
        if (hit == Prize.FOURTH.getHit()) {
            prize.put(Prize.FOURTH.getHit(), prize.get(Prize.FOURTH.getHit()) + 1);
            return;
        }
        if (hit == Prize.THIRD.getHit()) {
            prize.put(Prize.THIRD.getHit(), prize.get(Prize.THIRD.getHit()) + 1);
            return;
        }
        if (hit == Prize.SECOND.getHit()) {
            prize.put(Prize.SECOND.getHit(), prize.get(Prize.SECOND.getHit()) + 1);
            return;
        }
        if (hit == Prize.FIRST.getHit()) {
            prize.put(Prize.FIRST.getHit(), prize.get(Prize.FIRST.getHit()) + 1);
        }
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
}
