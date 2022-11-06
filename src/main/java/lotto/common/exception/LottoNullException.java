package lotto.common.exception;

import static lotto.common.Constants.COMMON_ERROR_MESSAGE;

public class LottoNullException extends IllegalArgumentException{
    public LottoNullException(String msg) {
        super(COMMON_ERROR_MESSAGE + msg);
    }
}
