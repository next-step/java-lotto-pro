package lotto.constants;

public class LottoErrorMessage {
    public static final String INVALID_LOTTO_NUMBER = "[ERROR] 로또 숫자는 1~45 사이의 숫자이어야 합니다. (number=%s)";
    public static final String MUST_BE_UNIQUE_NUMBER = "[ERROR] 로또 숫자는 중복될 수 없습니다. (numbers=%s)";
    public static final String INVALID_INPUT_LOTTO_NUMBER = "[ERROR] 로또 숫자는 1~45 사이의 숫자이어야 하며 중복이 될 수 없습니다. (number=%s)";
    public static final String INVALID_INPUT_BONUS_LOTTO_NUMBER = "[ERROR] 보너스 볼 숫자는 1~45 사이의 숫자이어야 하며 지난 주 당첨번호와 같은 번호일 수 없습니다. (입력=%s, 지난 주 당첨번호=%s)";
    public static final String INVALID_INPUT_MONEY = "[ERROR] 구매금액이 올바르지 않습니다. (money = %s)";
    public static final String INVALID_MANUAL_LOTTO_PURCHASE_COUNT = "[ERROR] 수동 구매횟수 값은 1~45 사이의 숫자이어야 하며 총 구매 횟수를 초괴할 수 없습니다. (input=%s, 총 구매 가능 횟수=%s)";
}
