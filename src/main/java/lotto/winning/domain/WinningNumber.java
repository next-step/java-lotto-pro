package lotto.winning.domain;

import common.vo.Number;
import lotto.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public static final int WINNING_NUMBER = 6;
    private static final String DUPLICATE_EXCEPTION_MESSAGE = "중복된 숫자를 입력할 수 없습니다.";
    private List<Number> winningNumbers = new ArrayList<>();

    public WinningNumber(String[] winningNumbers) {
        validateSize(winningNumbers);
        for (String number : winningNumbers) {
            validateDuplicate(number);
            add(number);
        }
    }

    private void add(String number) {
        this.winningNumbers.add(new Number(Integer.parseInt(number)));
    }

    private void validateDuplicate(String nunber) {
        for (Number value : this.winningNumbers) {
            validateDuplicateNumber(Integer.parseInt(nunber), value);
        }
    }

    private static void validateDuplicateNumber(int number, Number value) {
        if (value.equals(new Number(number))) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private static void validateSize(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER + "자리여야합니다.");
        }
    }

    public int findMatchingCount(Lotto lotto) {
        int matchCounts = 0;
        for (Number number : lotto.getLottos()) {
            matchCounts = plusMatchCounts(matchCounts, number);
        }
        return matchCounts;
    }

    private int plusMatchCounts(int matchCounts, Number number) {
        for (Number winningNumber : this.winningNumbers) {
            matchCounts = plusMatchCount(matchCounts, number, winningNumber);
        }
        return matchCounts;
    }

    private static int plusMatchCount(int matchCounts, Number number, Number winningNumber) {
        if (number.equals(winningNumber)) {
            matchCounts++;
        }
        return matchCounts;
    }
}
