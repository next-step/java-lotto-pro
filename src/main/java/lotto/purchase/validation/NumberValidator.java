package lotto.purchase.validation;

import java.util.regex.Pattern;

public class NumberValidator implements PurchaseValidator {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(String purchase) {
        if (!NUMBER_PATTERN.matcher(purchase).matches()) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }
}
