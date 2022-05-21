package lotto.exception;

import lotto.constant.Message;

public class LottoLineSizeException extends IllegalArgumentException{
    public LottoLineSizeException() {
        super(Message.ERROR_LOTTO_LINE_LENGTH_NOT_MATCH);
    }
}
