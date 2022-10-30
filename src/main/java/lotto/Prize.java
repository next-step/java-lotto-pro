package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prize {
    private final Map<Integer, Integer> prize = new HashMap<>();
    private final List<Integer> winningNumbers;

    public Prize(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
        prize.put(6, 0);
        prize.put(5, 0);
        prize.put(4, 0);
        prize.put(3, 0);
    }

    public void countPrize(List<LottoNumber> lottoNumbers) {
        for (LottoNumber lottoNumber : lottoNumbers) {
            int hit = lottoNumber.countHit(winningNumbers);
            if (hit == 3) {
                prize.put(hit, prize.get(3) + 1);
                continue;
            }
            if (hit == 4) {
                prize.put(hit, prize.get(4) + 1);
                continue;
            }
            if (hit == 5) {
                prize.put(hit, prize.get(5) + 1);
                continue;
            }
            if (hit == 6) {
                prize.put(hit, prize.get(6) + 1);
            }
        }
    }

    public int getCountOfFirst() {
        return prize.get(6);
    }

    public int getCountOfSecond() {
        return prize.get(5);
    }

    public int getCountOfThird() {
        return prize.get(4);
    }

    public int getCountOfFourth() {
        return prize.get(3);
    }
}
