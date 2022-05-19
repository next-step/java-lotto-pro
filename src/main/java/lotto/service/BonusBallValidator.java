package lotto.service;

import static lotto.domain.message.ErrorMessage.INVALID_BONUS_BALL;

import lotto.domain.BonusBall;
import lotto.domain.LottoNumbers;

public class BonusBallValidator {
    public static void validate(final BonusBall bonusBall, final LottoNumbers winningNumbers) {
        if (winningNumbers.matchesBonusBall(bonusBall)) {
            throw new IllegalArgumentException(INVALID_BONUS_BALL.getMessage());
        }
    }
}
