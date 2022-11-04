package lotto.winning.domain;

import common.vo.Number;
import lotto.lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Number> winningNumbers = new ArrayList<>();

    public WinningNumber(String[] winningNumbers) {
        for (String number : winningNumbers) {
            this.winningNumbers.add(new Number(Integer.parseInt(number)));
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
