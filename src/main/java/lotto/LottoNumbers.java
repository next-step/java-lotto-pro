package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers;
    Map<Integer, Integer> prize = new HashMap<>();

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        prize.put(6, 0);
        prize.put(5, 0);
        prize.put(4, 0);
        prize.put(3, 0);
    }

    public int purchaseCount() {
        return lottoNumbers.size();
    }

    public void countPrize(List<Integer> winningNumbers) {
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

    public int countFirst() {
        return prize.get(6);
    }

    public int countSecond() {
        return prize.get(5);
    }

    public int countThird() {
        return prize.get(4);
    }

    public int countFourth() {
        return prize.get(3);
    }
}
