package lotto.constants;

public class LottoGameErrorMessage {
    private LottoGameErrorMessage() {}

    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 숫자는 1부터 45 사이의 값이어야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_NOT_UNIQUE = "[ERROR] 로또 숫자는 중복될 수 없습니다.";
    public static final String INVALID_LOTTO_NUMBERS_SIZE = "[ERROR] 로또 숫자는 6개로 이루어져야 합니다.";
    public static final String INSUFFICIENT_MONEY = "[ERROR] 받은 금액으로 로또를 구매하기에 부족합니다.";
    public static final String INVALID_MONEY_LEFT = "[ERROR] 1000원 단위의 금액을 지불해주세요.";
}
