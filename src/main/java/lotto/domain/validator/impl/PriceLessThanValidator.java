package lotto.domain.validator.impl;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import lotto.domain.validator.PriceValidator;
import lotto.exception.ExceptionType;

public class PriceLessThanValidator implements PriceValidator {

    @Override
    public void validate(int price) {
        if (LOTTO_PRICE > price) {
            throw new IllegalArgumentException(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
        }
    }
}
