package domain;

import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int countOfMatch(Set<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusNumberMatched(Set<Integer> numbers) {
        return numbers.contains(bonusNumber);
    }
}
