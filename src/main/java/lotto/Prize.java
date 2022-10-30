package lotto;

import static lotto.Constant.HIT_FIVE;
import static lotto.Constant.HIT_FOUR;
import static lotto.Constant.HIT_SIX;
import static lotto.Constant.HIT_THREE;
import static lotto.Constant.ZERO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Prize {
    private final Map<Integer, Integer> prize = new HashMap<>();
    private final List<Integer> winningNumbers;

    public Prize(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        initialize();
    }

    private void initialize() {
        prize.put(HIT_SIX, ZERO);
        prize.put(HIT_FIVE, ZERO);
        prize.put(HIT_FOUR, ZERO);
        prize.put(HIT_THREE, ZERO);
    }

    public void countPrize(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            inputCountPrize(lottoNumber.countHit(winningNumbers));
        }
    }

    private void inputCountPrize(int hit) {
        if (hit == HIT_THREE) {
            prize.put(hit, prize.get(HIT_THREE) + 1);
            return;
        }
        if (hit == HIT_FOUR) {
            prize.put(hit, prize.get(HIT_FOUR) + 1);
            return;
        }
        if (hit == HIT_FIVE) {
            prize.put(hit, prize.get(HIT_FIVE) + 1);
            return;
        }
        if (hit == HIT_SIX) {
            prize.put(hit, prize.get(HIT_SIX) + 1);
        }
    }

    public int getCountOfFirst() {
        return prize.get(HIT_SIX);
    }

    public int getCountOfSecond() {
        return prize.get(HIT_FIVE);
    }

    public int getCountOfThird() {
        return prize.get(HIT_FOUR);
    }

    public int getCountOfFourth() {
        return prize.get(HIT_THREE);
    }
}
