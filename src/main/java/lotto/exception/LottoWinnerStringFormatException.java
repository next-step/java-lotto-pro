package lotto.exception;

import lotto.constant.Message;

public class LottoWinnerStringFormatException extends NumberFormatException{
    public LottoWinnerStringFormatException() {
        super(Message.ERROR_LOTTO_WINNER_STRING_FORMAT);
    }
}
