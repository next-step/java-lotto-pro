package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public static final int WINNING_NUMBER = 6;
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자를 입력할 수 없습니다.";
    private static final int INIT_COUNT = 0;
    private List<Number> winningNumbers = new ArrayList<>();

    public WinningNumber(String[] winningNumbers) {
        validateSize(winningNumbers);
        for (String number : winningNumbers) {
            validateDuplicate(number);
            add(number);
        }
    }

    private void validateDuplicate(String nunber) {
        for (Number value : this.winningNumbers) {
            validateDuplicateNumber(Integer.parseInt(nunber), value);
        }
    }

    private void validateDuplicateNumber(int number, Number value) {
        if (value.equals(new Number(number))) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateSize(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER + "자리여야합니다.");
        }
    }

    private void add(String number) {
        this.winningNumbers.add(new Number(Integer.parseInt(number)));
    }

    public int findMatchingCount(Lotto lotto) {
        int matchCounts = INIT_COUNT;
        for (Number number : lotto.getLotto()) {
            matchCounts = plusMatchingCount(matchCounts, number);
        }
        return matchCounts;
    }

    private int plusMatchingCount(int matchCounts, Number number) {
        if (this.winningNumbers.contains(number)) {
            matchCounts++;
        }
        return matchCounts;
    }

    public boolean contains(Number number) {
        return this.winningNumbers.contains(number);
    }
}
