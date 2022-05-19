package lotto.domain.validator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.impl.OverlapLottoNumbersValidator;
import lotto.domain.validator.impl.DefaultFormatLottoNumbersValidator;
import lotto.domain.validator.impl.InvalidLottoNumberSizeValidator;

public class LottoNumbersValidatorGroup {

    private final List<LottoNumbersValidator> validators;

    private LottoNumbersValidatorGroup() {
        this.validators = Arrays.asList(
            new DefaultFormatLottoNumbersValidator(),
            new InvalidLottoNumberSizeValidator(),
            new OverlapLottoNumbersValidator()
        );
    }

    private static class LazyHolder {

        private static LottoNumbersValidatorGroup instance = new LottoNumbersValidatorGroup();
    }

    public static LottoNumbersValidatorGroup getInstance() {
        return LazyHolder.instance;
    }

    public void validate(String winningNumbers) {
        this.validators.forEach(validator -> validator.validate(winningNumbers));
    }
}
