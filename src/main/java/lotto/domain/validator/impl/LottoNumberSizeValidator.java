package lotto.domain.validator.impl;

import lotto.domain.Lotto;
import lotto.domain.validator.NumberValidator;
import lotto.exception.ExceptionType;

public class LottoNumberSizeValidator implements NumberValidator {

    @Override
    public void validate(String number) {
        int lottoNumber = Integer.parseInt(number);
        if (Lotto.isLottoNumberSize(lottoNumber)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }
    }
}
