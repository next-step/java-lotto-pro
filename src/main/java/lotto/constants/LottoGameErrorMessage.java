package lotto.constants;

public class LottoGameErrorMessage {
    private LottoGameErrorMessage() {}

    public static final String INVALID_LOTTO_NUMBER_RANGE = "[ERROR] 로또 숫자는 1부터 45 사이의 값이어야 합니다.";
    public static final String INVALID_LOTTO_NUMBER_NOT_UNIQUE = "[ERROR] 로또 숫자는 중복될 수 없습니다.";
    public static final String INVALID_BONUS_LOTTO_NUMBER = "[ERROR] 보너스 볼 숫자는 지난 주 당첨번호와 같을 수 없습니다.";

    public static final String INVALID_LOTTO_NUMBERS_SIZE = "[ERROR] 로또 숫자는 6개로 이루어져야 합니다.";
    public static final String INSUFFICIENT_MONEY = "[ERROR] 받은 금액으로 로또를 구매하기에 부족합니다.";
    public static final String INVALID_MONEY_LEFT = "[ERROR] 1000원 단위의 금액을 지불해주세요.";
    public static final String INVALID_MANUAL_LOTTO_PURCHASE_COUNT = "[ERROR] 수동 구매횟수 값은 0보다 커야하며, 구매가능한 전체 횟수를 넘을 수 없습니다.";
}
