package lotto.validator.impl;

import lotto.domain.LottoShop;
import lotto.exception.ExceptionType;
import lotto.validator.PriceValidator;

public class PriceLessThanValidator implements PriceValidator {

    @Override
    public void validate(int price) {
        if (LottoShop.LOTTO_PRICE > price) {
            throw new IllegalArgumentException(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
        }
    }
}
