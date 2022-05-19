package lotto.domain;

import lotto.domain.validator.NumberValidator;
import lotto.domain.validator.impl.NumberFormatValidator;

public class ManualLottoCount {

    private final int manualLottoCount;
    private static final NumberValidator numberValidator = new NumberFormatValidator();

    public ManualLottoCount(String manualLottoCount) {
        numberValidator.validate(manualLottoCount);
        this.manualLottoCount = Integer.parseInt(manualLottoCount);
    }

    public int getManualLottoCount() {
        return manualLottoCount;
    }
}
