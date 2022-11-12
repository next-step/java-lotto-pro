package lotto.model.constants;

public class ErrorMessage {

    public static final String PURCHASE_AMOUNT_MUST_POSITIVE = "구입 금액은 0원 보다 커야합니다.";
    public static final String LOTTO_NUMBER_CONSTRAINT = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_NUMBER = "구입 금액은 숫자로만 입력해주세요.";
    public static final String LOTTO_NUMBER_NOT_STRING = "로또 번호에 문자 입력은 불가합니다.";
    public static final String LOTTO_NUMBER_COUNT_MAX = "번호를 초과 입력하였습니다. 로또 1장당 번호는 6개 입니다.";
    public static final String RANK_NOT_POSITIVE = "당첨 순위는 0 보다 커야합니다.";
    public static final String MATCH_COUNT_NEGATIVE = "일치 기준 개수는 음수일 수 없습니다.";
    public static final String PRIZE_NOT_POSITIVE = "상금 금액은 0 보다 커야합니다.";
    public static final String LOTTO_NUMBER_EXIST = "1장의 로또는 중복되지 않은 수로 구성되어야 합니다.";
    public static final String LOTTO_NUMBER_COUNT_NOT_MATCH = "로또 1장당 번호를 6개 입력해야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_ENOUGH = "구입 금액이 1장 가격보다 작습니다.";
    public static final String INVALID_LOTTO_UNIT_PRICE = "로또 1장 가격이 잘 못 설정되어있습니다.";
    public static final String INVALID_PURCHASE_AMOUNT = "잘 못된 구입금액입니다. 잔액이 발생했습니다.";
    public static final String PURCHASE_TOTAL_COUNT_NOT_POSITIVE = "구입 총 개수는 0보다 커야 합니다.";
    public static final String MANUAL_LOTTO_PURCHASE_COUNT_NEGATIVE = "수동 로또 구입 개수는 음수일 수 없습니다.";
    public static final String INVALID_MANUAL_LOTTO_PURCHASE_COUNT = "수동 로또 구입 개수는 숫자로 입력해주세요.";
    public static final String MANUAL_LOTTO_PURCHASE_COUNT_EXCEED = "수동 로또 구입 개수는 총 구입 개수보다 클 수 없습니다.";
    public static final String BONUS_BALL_NUMBER_EXIST = "보너스볼은 당첨 번호와 중복될 수 없습니다.";
    public static final String MANUAL_LOTTO_DUPLICATE = "중복 입력된 수동 로또 번호가 있습니다.";
}
