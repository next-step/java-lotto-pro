package lotto;

import java.util.List;

public class LottoNumber {
    private final List<Integer> sixNumbers;

    public LottoNumber(List<Integer> sixNumbers) {
        this.sixNumbers = sixNumbers;
    }

    public int countHit(List<Integer> winningNumbers) {
        int count = 0;
        for (int winningNumber : winningNumbers) {
            if (sixNumbers.contains(winningNumber)) {
                count++;
            }
        }
        return count;
    }
}
