package lotto.domain.lottonumber.purchase.factory.validation;

import java.util.regex.Pattern;

public class NumberValidator implements PurchaseValidator {
    private static final String ERROR_NUMBER_MESSAGE = "[ERROR] 숫자로만 입력해주세요.";
    private static final Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]+$");

    @Override
    public void validate(String purchase) {
        if (!NUMBER_PATTERN.matcher(purchase).matches()) {
            throw new IllegalArgumentException(ERROR_NUMBER_MESSAGE);
        }
    }
}
