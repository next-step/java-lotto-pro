package lotto.model.vo;

import lotto.model.constants.ErrorMessage;
import lotto.model.constants.LottoConstants;

public class LottoNumber {

    private int lottoNumber;

    public LottoNumber(int lottoNumber) {
        setLottoNumber(lottoNumber);
    }

    public LottoNumber(String lottoNumber) {
        int number = parseInt(lottoNumber);
        setLottoNumber(number);
    }

    protected static boolean validateNumber(int checkValue) {
        return checkValue >= LottoConstants.LOTTO_NUMBER_MIN && checkValue <= LottoConstants.LOTTO_NUMBER_MAX;
    }

    private void setLottoNumber(int lottoNumber) {
        if (!validateNumber(lottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_CONSTRAINT);
        }
        this.lottoNumber = lottoNumber;
    }

    protected static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NOT_STRING);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
