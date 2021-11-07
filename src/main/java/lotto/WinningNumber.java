package lotto;

public class WinningNumber {
    private final String[] winningNumber;

    public WinningNumber(String[] winningNumber) {
        this.winningNumber = winningNumber;
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
