/*
 * WinningNumber.java
 * v0.1
 * 2022.10.31
 */
package lotto;

import java.util.List;
import java.util.Objects;

public class WinningNumber {
    private final List<Integer> winningNumbers;

    public WinningNumber(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public int countHit(LottoNumber lottoNumber) {
        return (int) winningNumbers.stream()
                .filter(lottoNumber::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
