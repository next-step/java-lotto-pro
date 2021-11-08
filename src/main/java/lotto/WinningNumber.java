package lotto;

public class WinningNumber {
    public static final String LENGTH_INVALID_MESSAGE = "당첨 번호가 6개가 아닙니다.";
    public static final int WINNING_NUMBER_LENGTH = 6;
    private final String[] winningNumber;

    public WinningNumber(String[] winningNumber) {
        validNumberLength(winningNumber);
        this.winningNumber = winningNumber;
    }

    private void validNumberLength(String[] winningNumber) {
        if(winningNumber.length != WINNING_NUMBER_LENGTH) {
            throw new IllegalArgumentException(LENGTH_INVALID_MESSAGE);
        }
    }


    public static WinningNumber createWinningNumber(String[] enterWinningNumber) {
        return new WinningNumber(enterWinningNumber);
    }

    public int length() {
        return winningNumber.length;
    }

    public String[] getWinningNumber() {
        return winningNumber;
    }
}
