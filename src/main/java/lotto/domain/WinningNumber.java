package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private static final int INIT_COUNT = 0;
    private Lotto winningNumber;

    public WinningNumber(String[] winningNumbers) {
        this.winningNumber = new Lotto(numbers(winningNumbers));
    }

    private List<Integer> numbers(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int findMatchingCount(Lotto lotto) {
        int matchCounts = INIT_COUNT;
        for (Number number : this.winningNumber.getLotto()) {
            matchCounts = plusMatchingCount(matchCounts, number, lotto);
        }
        return matchCounts;
    }

    private int plusMatchingCount(int matchCounts, Number number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            matchCounts++;
        }
        return matchCounts;
    }

    public boolean contains(Number number) {
        return this.winningNumber.getLotto().contains(number);
    }
}
