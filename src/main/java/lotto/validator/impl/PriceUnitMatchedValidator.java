package lotto.validator.impl;

import lotto.domain.LottoShop;
import lotto.exception.ExceptionType;
import lotto.validator.PriceValidator;

public class PriceUnitMatchedValidator implements PriceValidator {

    @Override
    public void validate(int price) {
        if ((price % LottoShop.LOTTO_PRICE) > 0) {
            throw new IllegalArgumentException(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
        }
    }
}
