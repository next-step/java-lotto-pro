package lotto.exception;

import lotto.constant.Message;

public class LottoNumberRangeException extends IllegalArgumentException{
    public LottoNumberRangeException() {
        super(Message.ERROR_NUMBER_RANGE_VIOLATION);
    }
}
