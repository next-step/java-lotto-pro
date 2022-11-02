/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> sixNumbers;
    private final int bonusNumber;

    public LottoNumbers(List<Integer> sixNumbers) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = 0;
    }

    public LottoNumbers(List<Integer> sixNumbers, int bonusNumber) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return sixNumbers.contains(number);
    }

    public boolean containsBonus(LottoNumbers lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    public int countHit(LottoNumbers lottoNumbers) {
        return (int) sixNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
