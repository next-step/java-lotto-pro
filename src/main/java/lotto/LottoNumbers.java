/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import static lotto.Rank.valueOf;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<LottoNumber> sixNumbers;

    private LottoNumbers(Set<LottoNumber> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public static LottoNumbers from(Set<LottoNumber> sixNumbers) {
        return new LottoNumbers(sixNumbers);
    }

    public static LottoNumbers from(List<Integer> sixNumbers) {
        return new LottoNumbers(toSet(sixNumbers));
    }

    private static Set<LottoNumber> toSet(List<Integer> sixNumbers) {
        return sixNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toSet());
    }

    public boolean contains(LottoNumber lottoNumber) {
        return sixNumbers.contains(lottoNumber);
    }

    public int countHit(LottoNumbers lottoNumbers) {
        return (int) sixNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    public Rank getRank(LottoNumbers winningNumbers, LottoNumber bonus) {
        return valueOf(countHit(winningNumbers), contains(bonus));
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
