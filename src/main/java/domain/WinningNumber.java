package domain;

import java.util.List;
import java.util.Set;

public class WinningNumber {
    private final List<Integer> winningNumbers;
    private final BonusWinningNumber bonusWinningNumber;

    public WinningNumber(List<Integer> winningNumbers, BonusWinningNumber bonusWinningNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public int countOfMatch(Set<Integer> numbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean isBonusNumberMatched(Set<Integer> numbers) {
        return bonusWinningNumber.in(numbers);
    }
}
