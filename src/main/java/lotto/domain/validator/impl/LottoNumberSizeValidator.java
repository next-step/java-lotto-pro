package lotto.domain.validator.impl;

import lotto.domain.LottoNo;
import lotto.domain.validator.NumberValidator;
import lotto.exception.ExceptionType;

public class LottoNumberSizeValidator implements NumberValidator {

    @Override
    public void validate(String number) {
        int lottoNumber = Integer.parseInt(number);
        if (LottoNo.isLottoNumberSize(lottoNumber)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }
    }
}
