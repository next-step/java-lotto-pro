package lotto.domain.winningnumber.factory.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultWinningNumberValidator implements WinningNumberValidator {

    private static final String WINNING_NUMBER_SEPARATOR = ",";
    private final List<WinningNumberValidator> validators;

    public DefaultWinningNumberValidator() {
        this.validators = Arrays.asList(new CountValidator(), new WinningNumberTypeValidator(), new RangeValidator());
    }

    @Override
    public void validate(String winningNumbers) {
        if (!winningNumbers.contains(WINNING_NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_SEPARATOR_MESSAGE);
        }
        validate(new HashSet<>(Arrays.asList(winningNumbers.split(WINNING_NUMBER_SEPARATOR))));
    }

    @Override
    public void validate(Set<String> winningNumbers) {
        for (WinningNumberValidator validator : validators) {
            validator.validate(winningNumbers);
        }
    }
}
