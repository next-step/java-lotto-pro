package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLotto {
    private static final int INIT_COUNT = 0;

    private final Lotto winningNumber;
    private final BonusBall bonusBall;

    public WinningLotto(String[] winningNumbers, BonusBall bonusBall) {
        this.winningNumber = new Lotto(numbers(winningNumbers));
        validateDuplicateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private void validateDuplicateBonusBall(BonusBall bonusBall) {
        if (winningNumber.getNumbers().contains(bonusBall.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }

    private List<Integer> numbers(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public int findMatchingCount(Lotto lotto) {
        int matchCounts = INIT_COUNT;
        for (Number number : this.winningNumber.getLotto()) {
            matchCounts = plusMatchingCount(matchCounts, number, lotto);
        }
        return matchCounts;
    }

    private int plusMatchingCount(int matchCounts, Number number, Lotto lotto) {
        if (lotto.getNumbers().contains(number)) {
            matchCounts++;
        }
        return matchCounts;
    }

    public boolean contains(Number number) {
        return this.winningNumber.getLotto().contains(number);
    }
}
