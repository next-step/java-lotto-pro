package lotto.domain;

import lotto.message.InputMessage;

public class LottoNumber {
    private final int lottoNumber;
    private final String LOTTO_NUMBER_REGEX = "^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public LottoNumber(String lottoNumber) {
        validateNumber(lottoNumber);
        this.lottoNumber = Integer.parseInt(lottoNumber);
    }

    private void validateNumber(String lottoNumber) {
        if (!lottoNumber.matches(LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException(InputMessage.INVALID_LOTTO_NUMBER);
        }
    }

    public int getLottoNumber() {
        return lottoNumber;
    }
}
