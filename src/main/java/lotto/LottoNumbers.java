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

public class LottoNumbers {
    private final List<LottoNumber> sixNumbers;

    private LottoNumbers(List<LottoNumber> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public static LottoNumbers from(List<Integer> sixNumbers) {
        Validate.isSixNumbers(sixNumbers);
        Collections.sort(sixNumbers);
        return new LottoNumbers(sixNumbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
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
