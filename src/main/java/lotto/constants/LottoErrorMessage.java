package lotto.constants;

public final class LottoErrorMessage {
    public static final String INVALID_MONEY_FORMAT = "올바른 금액 양식이 아닙니다.";
    public static final String MONEY_LESS_THAN_PRICE = "로또 한 장의 금액보다 입력한 금액이 적습니다.";
    public static final String INVALID_LOTTO_NUMBER_FORMAT = "올바른 로또 번호 양식이 아닙니다.";
    public static final String DUPLICATE_LOTTO_NUMBER = "로또 숫자의 중복은 허용되지 않습니다.";
    public static final String OUT_OF_RANGE_LOTTO_NUMBER = "로또 숫자 범위를 벗어났습니다.";
    public static final String OUT_OF_RANGE_LOTTO_RANK = "로또 등수의 범위가 아닙니다.";

    private LottoErrorMessage() {
    }
}
