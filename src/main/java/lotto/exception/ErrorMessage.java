package lotto.exception;

import lotto.domain.Lotto;
import lotto.domain.LottoIssuanceCount;
import lotto.domain.LottoNumber;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON(String.format("로또 구입금액은 %d원 단위 입니다.", LottoIssuanceCount.LOTTO_PRICE)),
    LOTTO_NUMBER_COUNT(String.format("로또 번호는 %d개 입니다.", Lotto.LOTTO_COUNT)),
    LOTTO_NUMBER_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자입니다.", LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_END_NUMBER)),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_WINNING_NUMBER_COUNT(String.format("당첨 번호는 %d개 입니다.", Lotto.LOTTO_COUNT)),
    LOTTO_WINNING_NUMBER_RANGE(String.format("당첨 번호는 %d부터 %d 사이의 숫자입니다.", LottoNumber.LOTTO_START_NUMBER, LottoNumber.LOTTO_END_NUMBER));

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
