package lotto.domain.winningnumber.factory;

import lotto.domain.winningnumber.WinningNumber;
import lotto.domain.winningnumber.factory.validation.DefaultWinningNumberValidator;
import lotto.domain.winningnumber.factory.validation.WinningNumberValidator;

public class WinningNumberFactoryImpl implements WinningNumberFactory {

    private WinningNumberValidator validator;
    private String winningNumber;

    public WinningNumberFactoryImpl(String winningNumber) {
        this.winningNumber = winningNumber;
        this.validator = new DefaultWinningNumberValidator();
    }

    @Override
    public WinningNumber createWinningNumber() {
        validator.validate(winningNumber);
        return new WinningNumber(winningNumber);
    }
}
