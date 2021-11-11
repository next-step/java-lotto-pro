package lotto;

import java.util.Arrays;

public class WinningNumber {
    public static final String LENGTH_INVALID_MESSAGE = "당첨 번호가 6개가 아닙니다.";
    public static final int WINNING_NUMBER_LENGTH = 6;

    private final String[] winningNumber;
    private final int bonusNumber;

    public WinningNumber(String[] winningNumber, int bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        validNumberLength(winningNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(String[] winningNumber, int bonusNumber) {
        if (Arrays.asList(winningNumber).contains(String.valueOf(bonusNumber))) {
            throw new IllegalArgumentException("당첨번호와 보너스 번호가 일치할 수 없습니다.");
        }
    }

    private void validNumberLength(String[] winningNumber) {
        if (winningNumber.length != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_INVALID_MESSAGE);
        }
    }


    public static WinningNumber createWinningNumber(String[] enterWinningNumber, int bonusNumber) {
        return new WinningNumber(enterWinningNumber, bonusNumber);
    }

    public int length() {
        return winningNumber.length;
    }

    public String[] getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
