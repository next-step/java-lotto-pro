package lotto.domain.exception;

import lotto.domain.LottoProperty;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON("로또 구입금액은" + LottoProperty.LOTTO_PRICE + "원 단위 입니다."),
    LOTTO_NUMBER_COUNT("로또 번호는 " + LottoProperty.LOTTO_COUNT + " 개 입니다."),
    LOTTO_NUMBER_RANGE("로또 번호는 " + LottoProperty.LOTTO_START_NUMBER + " 부터 " + LottoProperty.LOTTO_END_NUMBER + " 사이의 숫자입니다."),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
