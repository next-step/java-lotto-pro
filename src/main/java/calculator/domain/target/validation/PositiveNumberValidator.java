package calculator.domain.target.validation;

import java.util.regex.Pattern;

public class PositiveNumberValidator implements CalculatorValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(String target) {
        if (!NUMBER_PATTERN.matcher(target).matches()) {
            throw new RuntimeException(ERROR_NUMBER_MESSAGE);
        }
    }
}
