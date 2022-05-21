package lotto.exception;

import lotto.constant.Message;

public class LottoLineDuplicationException extends IllegalArgumentException{
    public LottoLineDuplicationException() {
        super(Message.ERROR_LOTTO_DUPLICATE_NUMBER);
    }
}
