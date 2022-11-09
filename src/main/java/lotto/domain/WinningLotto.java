package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLotto {

    private final Lotto winningLotto;
    private final Number bonusBall;

    public WinningLotto(String[] winningLottos, Number bonusBall) {
        this.winningLotto = new Lotto(numbers(winningLottos));
        validateDuplicateBonusBall(bonusBall);
        this.bonusBall = bonusBall;
    }

    private List<Integer> numbers(String[] winningLottos) {
        List<Integer> numbers = new ArrayList<>();
        for (String number : winningLottos) {
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    private void validateDuplicateBonusBall(Number bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    public Number getBonusBall() {
        return this.bonusBall;
    }

    public boolean contains(Number number) {
        return this.winningLotto.contains(number);
    }
}
