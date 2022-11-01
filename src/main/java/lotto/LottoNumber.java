/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.List;

public class LottoNumber {
    private final List<Integer> sixNumbers;
    private final int bonusNumber;

    public LottoNumber(List<Integer> sixNumbers) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = 0;
    }

    public LottoNumber(List<Integer> sixNumbers, int bonusNumber) {
        this.sixNumbers = sixNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int number) {
        return sixNumbers.contains(number);
    }

    public boolean containsBonus(LottoNumber lottoNumber) {
        return lottoNumber.contains(bonusNumber);
    }

    public int countHit(LottoNumber lottoNumber) {
        return (int) sixNumbers.stream()
                .filter(lottoNumber::contains)
                .count();
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
