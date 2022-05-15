package lotto.validator.impl;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.exception.ExceptionType;
import lotto.validator.PriceValidator;

public class PriceUnitMatchedValidator implements PriceValidator {

    @Override
    public void validate(int price) {
        if ((price % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
        }
    }
}
