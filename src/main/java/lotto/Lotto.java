/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Rank.valueOf;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> sixNumbers;

    private Lotto(List<LottoNumber> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public static Lotto from(List<Integer> sixNumbers) {
        Validate.isSixNumbers(sixNumbers);
        Collections.sort(sixNumbers);
        return new Lotto(sixNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    public boolean contains(LottoNumber lottoNumber) {
        return sixNumbers.contains(lottoNumber);
    }

    public void isContainsBonus(LottoNumber bonus) {
        Validate.isDuplicate(bonus, sixNumbers);
    }

    public int countHit(Lotto lotto) {
        return (int) sixNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    public Rank getRank(Lotto winningNumbers, LottoNumber bonus) {
        return valueOf(countHit(winningNumbers), contains(bonus));
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
