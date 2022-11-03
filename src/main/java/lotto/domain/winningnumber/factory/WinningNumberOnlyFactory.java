package lotto.domain.winningnumber.factory;

import lotto.domain.validation.DefaultNumberValidator;
import lotto.domain.validation.NumberValidator;
import lotto.domain.winningnumber.WinningNumber;
import lotto.domain.winningnumber.WinningNumberOnly;

public class WinningNumberOnlyFactory implements WinningNumberFactory {

    private NumberValidator validator;
    private String winningNumber;

    public WinningNumberOnlyFactory(String winningNumber) {
        this.winningNumber = winningNumber;
        this.validator = new DefaultNumberValidator();
    }

    @Override
    public WinningNumber createWinningNumber() {
        validator.validate(winningNumber);
        return new WinningNumberOnly(winningNumber);
    }
}
