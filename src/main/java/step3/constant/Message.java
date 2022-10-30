package step3.constant;

public class Message {
    public static final String TOTAL_LOTTO_PRICE_INPUT_MESSAGE = "구매금액을 입력해 주세요.";
    public static final String LAST_LOTTO_NUMBERS_INPUT_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String PURCHASED_LOTTO_TOTAL_COUNT_OUTPUT_MESSAGE = "%d개를 구매했습니다.\n";
    public static final String WINNER_STATISTICS = "\n당첨 통계";
    public static final String SPLIT_LINE = "---------";
    public static final String PROFIT_RATE_RESULT = "총 수익률은 %.2f입니다.";

    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String NOT_VALID_NULL = ERROR_PREFIX + "빈 값은 입력할 수 없습니다.";
    public static final String ERROR_IS_NUMBERIC = ERROR_PREFIX + "숫자만 입력 가능합니다.";
    public static final String UNDER_MIN_PRICE = ERROR_PREFIX + "금액이 부족합니다.";
    public static final String UNVALID_LOTTO_NUMBER_LENGTH = ERROR_PREFIX + "로또 번호는 6개만 입력 가능합니다.";
    public static final String SMAE_LOTTO_NUMBER = ERROR_PREFIX + "중복된 숫자가 입력되었습니다.";
}
