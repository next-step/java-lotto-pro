package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Lotto.DUPLICATE_EXCEPTION_MESSAGE;

public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusBall bonusBall;

    public WinningLotto(String[] winningLottos, BonusBall bonusBall) {
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
