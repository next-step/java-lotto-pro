package lotto.model.vo;

import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class LottoNumber {

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        if (!validateNumber(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_CONSTRAINT);
        }
        this.lottoNumber = lottoNumber;
    }
    public static boolean validateNumber(int checkValue) {
        return checkValue >= LottoConstants.LOTTO_NUMBER_MIN && checkValue <= LottoConstants.LOTTO_NUMBER_MAX;
    }
}
