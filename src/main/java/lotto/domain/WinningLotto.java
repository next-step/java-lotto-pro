package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusBall bonusBall;

    public WinningLotto(String[] winningNumbers, BonusBall bonusBall) {
        this.winningLotto = new Lotto(numbers(winningNumbers));
        validateDuplicateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private List<Integer> numbers(String[] winningNumbers) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningNumbers) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validateDuplicateBonusBall(BonusBall bonusBall) {
        if (winningLotto.getNumbers().contains(bonusBall.getNumber())) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public BonusBall getBonusBall() {
        return bonusBall;
    }

    public boolean contains(Number number) {
        return this.winningLotto.contains(number);
    }
}
