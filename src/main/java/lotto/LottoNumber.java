/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.List;

public class LottoNumber {
    private final List<Integer> sixNumbers;

    public LottoNumber(List<Integer> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public boolean contains(int number) {
        return sixNumbers.contains(number);
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
