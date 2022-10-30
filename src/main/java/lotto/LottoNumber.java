/*
 * LottoNumber.java
 * v0.1
 * 2022.10.30
 */
package lotto;

import java.util.List;

class LottoNumber {
    private final List<Integer> sixNumbers;

    public LottoNumber(List<Integer> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public int countHit(List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            count += isContain(winningNumber);
        }
        return count;
    }

    private int isContain(int winningNumber) {
        if (sixNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return sixNumbers.toString();
    }
}
