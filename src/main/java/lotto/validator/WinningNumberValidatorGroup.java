package lotto.validator;

import java.util.Arrays;
import java.util.List;
import lotto.validator.impl.DefaultFormatWinningNumbersValidator;
import lotto.validator.impl.InvalidWinningNumberSizeValidator;
import lotto.validator.impl.OverlapWinningNumbersValidator;

public class WinningNumberValidatorGroup {

    private final List<WinningNumbersValidator> validators;

    private WinningNumberValidatorGroup() {
        this.validators = Arrays.asList(
            new DefaultFormatWinningNumbersValidator(),
            new InvalidWinningNumberSizeValidator(),
            new OverlapWinningNumbersValidator()
        );
    }

    private static class LazyHolder {

        private static WinningNumberValidatorGroup instance = new WinningNumberValidatorGroup();
    }

    public static WinningNumberValidatorGroup getInstance() {
        return LazyHolder.instance;
    }

    public void validate(String winningNumbers) {
        this.validators.forEach(validator -> validator.validate(winningNumbers));
    }
}
