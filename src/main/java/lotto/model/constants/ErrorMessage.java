package lotto.model.constants;

public class ErrorMessage {

    public static final String PURCHASE_COUNT_MUST_POSITIVE = "구매 개수는 1개 이상이어야 합니다.";
    public static final String LOTTO_NUMBER_CONSTRAINT = "로또 번호는 1 ~ 45 사이의 숫자이어야 합니다.";
    public static final String PURCHASE_AMOUNT_NOT_NUMBER = "구입 금액은 숫자로만 입력해주세요.";
    public static final String LOTTO_NUMBER_NOT_STRING = "로또 번호에 문자 입력은 불가합니다.";
    public static final String LOTTO_NUMBER_COUNT_MAX = "로또 1개당 번호는 6개까지 입력 가능합니다.";
    public static final String RANK_NOT_POSITIVE = "당첨 순위는 0 보다 커야합니다.";
    public static final String MATCH_COUNT_NEGATIVE = "일치 기준 개수는 음수일 수 없습니.";
    public static final String PRIZE_NOT_POSITIVE = "상금 금액은 0 보다 커야합니다.";
    public static final String LOTTO_NUMBER_EXIST = "1장의 로또는 중복되지 않은 수로 구성되어야 합니다.";
}
