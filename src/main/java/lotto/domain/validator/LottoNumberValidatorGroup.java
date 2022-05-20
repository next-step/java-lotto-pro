package lotto.domain.validator;

import java.util.Arrays;
import java.util.List;
import lotto.domain.validator.impl.LottoNumberSizeValidator;
import lotto.domain.validator.impl.NumberFormatValidator;

public class LottoNumberValidatorGroup {

    private final List<NumberValidator> validators;

    private LottoNumberValidatorGroup() {
        this.validators = Arrays.asList(
            new NumberFormatValidator(),
            new LottoNumberSizeValidator()
        );
    }

    private static class LazyHolder {
        private static LottoNumberValidatorGroup instance = new LottoNumberValidatorGroup();
    }

    public static LottoNumberValidatorGroup getInstance() {
        return LazyHolder.instance;
    }

    public void validate(String lottoNo) {
        this.validators.forEach(validator -> validator.validate(lottoNo));
    }

    public void validate(int lottoNo) {
        new LottoNumberSizeValidator().validate(String.valueOf(lottoNo));
    }
}
