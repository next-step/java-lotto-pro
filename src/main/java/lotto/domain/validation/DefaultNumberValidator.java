package lotto.domain.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultNumberValidator implements NumberValidator {

    private static final String ERROR_SEPARATOR_MESSAGE = "[ERROR] 쉼표(,)로 구분하여 입력해주세요.";
    private static final String NUMBER_SEPARATOR = ",";
    private final List<NumberValidator> validators;

    public DefaultNumberValidator() {
        this.validators = Arrays.asList(new CountValidator(), new NumberTypeValidator(), new RangeValidator());
    }

    @Override
    public void validate(String numbers) {
        if (!numbers.contains(NUMBER_SEPARATOR)) {
            throw new IllegalArgumentException(ERROR_SEPARATOR_MESSAGE);
        }
        validate(new HashSet<>(Arrays.asList(numbers.split(NUMBER_SEPARATOR))));
    }

    @Override
    public void validate(Set<String> numbers) {
        for (NumberValidator validator : validators) {
            validator.validate(numbers);
        }
    }
}
