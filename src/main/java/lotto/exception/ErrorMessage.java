package lotto.exception;

import lotto.domain.LottoProperty;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON(String.format("로또 구입금액은 %d원 단위 입니다.", LottoProperty.LOTTO_PRICE)),
    LOTTO_NUMBER_COUNT(String.format("로또 번호는 %d개 입니다.", LottoProperty.LOTTO_COUNT)),
    LOTTO_NUMBER_RANGE(String.format("로또 번호는 %d부터 %d 사이의 숫자입니다.", LottoProperty.LOTTO_START_NUMBER, LottoProperty.LOTTO_END_NUMBER)),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
