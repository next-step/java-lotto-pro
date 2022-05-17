package lotto.domain;

import lotto.domain.validator.BonusNumberValidatorGroup;

public class BonusNumber {

    private static final BonusNumberValidatorGroup validatorGroup = BonusNumberValidatorGroup.getInstance();
    private final int bonusNumber;

    public BonusNumber(String bonusNumber, WinningNumbers winningNumbers) {
        validatorGroup.validate(bonusNumber, winningNumbers.getWinningNumbersToArray());
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
