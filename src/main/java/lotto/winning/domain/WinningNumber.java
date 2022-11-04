package lotto.winning.domain;

import common.vo.Number;
import lotto.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    public static final int WINNING_NUMBER = 6;
    private List<Number> winningNumbers = new ArrayList<>();

    public WinningNumber(String[] winningNumbers) {
        validate(winningNumbers);
        for (String number : winningNumbers) {
            this.winningNumbers.add(new Number(Integer.parseInt(number)));
        }
    }

    private void validate(String[] winningNumbers) {
        if (winningNumbers.length != WINNING_NUMBER) {
            throw new IllegalArgumentException(WINNING_NUMBER + "자리여야합니다.");
        }
    }

    public int matchCounts(Lotto lotto) {
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
