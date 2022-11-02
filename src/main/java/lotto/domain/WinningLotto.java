package lotto.domain;

import java.util.List;

import static lotto.ui.ConsoleMessage.ERROR_VALID_BONUS_NUMBER;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusBall;

    public WinningLotto(final List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validate(numbers, bonusNumber);
        bonusBall = new LottoNumber(bonusNumber);
    }

    private void validate(final List<Integer> winningNumber, final int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_VALID_BONUS_NUMBER.getMessage());
        }
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
