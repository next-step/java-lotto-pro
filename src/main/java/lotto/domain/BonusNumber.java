package lotto.domain;

import lotto.domain.validator.BonusNumberValidatorGroup;

public class BonusNumber {

    private static final BonusNumberValidatorGroup validatorGroup = BonusNumberValidatorGroup.getInstance();
    private final int bonusNumber;

    public BonusNumber(String bonusNumber) {
        validatorGroup.validate(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
