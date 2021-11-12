package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningNumber {
    public static final String LENGTH_INVALID_MESSAGE = "당첨 번호가 6개가 아닙니다.";
    public static final int WINNING_NUMBER_LENGTH = 6;

    private final LotteryNumbers winningNumber;
    private final int bonusNumber;

    private WinningNumber(String[] winningNumber, int bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        validNumberLength(winningNumber);
        this.winningNumber = new LotteryNumbers(convertStringArrayToIntegerList(winningNumber));
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumber createWinningNumber(String[] enterWinningNumber, int bonusNumber) {
        return new WinningNumber(enterWinningNumber, bonusNumber);
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

    private List<Integer> convertStringArrayToIntegerList(String[] winningNumber) {
        return Arrays.stream(winningNumber).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

    public int countMatch(LotteryNumbers lotteryNumbers) {
        int cnt = 0;
        for (int no : lotteryNumbers.getLotteryNumber()) {
            if (winningNumber.contains(no)) {
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isMatchBonus(LotteryNumbers lotteryNumbers) {
        return lotteryNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WinningNumber that = (WinningNumber) o;

        if (bonusNumber != that.bonusNumber) return false;
        return Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        int result = winningNumber != null ? winningNumber.hashCode() : 0;
        result = 31 * result + bonusNumber;
        return result;
    }
}
