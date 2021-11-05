package lotto;

public enum ErrorMessage {

    PURCHASE_AMOUNT_NOT_ONE_THOUSAND_WON("로또 구입금액은" + LottoProperty.LOTTO_PRICE + "원 단위 입니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
