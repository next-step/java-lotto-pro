package domain;

import java.util.Set;

public class BonusWinningNumber {
    private final int bonusWinningNumber;

    public BonusWinningNumber(int bonusWinningNumber) {
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public boolean in(Set<Integer> numbers) {
        return numbers.contains(bonusWinningNumber);
    }
}
