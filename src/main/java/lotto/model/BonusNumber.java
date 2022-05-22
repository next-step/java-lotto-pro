package lotto.model;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int number, WinningNumber winningNumber) {
        bonusNumber = checkBonusNumber(number, winningNumber);
    }

    public int value () {
        return bonusNumber;
    }

    private int checkBonusNumber(int number, WinningNumber winningNumber) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 달라야합니다.");
        }
        return number;
    }
}
