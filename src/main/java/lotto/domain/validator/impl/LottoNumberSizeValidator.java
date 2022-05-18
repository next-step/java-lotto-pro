package lotto.domain.validator.impl;

import lotto.domain.validator.NumberValidator;
import lotto.exception.ExceptionType;
import lotto.utils.LottoUtils;

public class LottoNumberSizeValidator implements NumberValidator {

    @Override
    public void validate(String number) {
        int lottoNumber = Integer.parseInt(number);
        if (LottoUtils.isLottoNumberSize(lottoNumber)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_NUMBER_SIZE.getMessage());
        }
    }
}
