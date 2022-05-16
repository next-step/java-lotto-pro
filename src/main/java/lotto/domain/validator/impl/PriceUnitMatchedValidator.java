package lotto.domain.validator.impl;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.domain.validator.PriceValidator;
import lotto.exception.ExceptionType;

public class PriceUnitMatchedValidator implements PriceValidator {

    @Override
    public void validate(int price) {
        if ((price % LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
        }
    }
}
