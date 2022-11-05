package lotto.constant;

public class LottoMessage {
    public static final String ERROR_LOTTO_SIZE = "[ERROR] Lotto는 6개의 숫자입니다.";
    public static final String ERROR_LOTTO_DUPLICATE_NUMBER = "[ERROR] Lotto 내 숫자는 중복될 수 없습니다.";
    public static final String ERROR_LOTTO_NUMBER_RANGE = "[ERROR] LottoNumber는 1 이상 45 이하여야 합니다.";
    public static final String ERROR_MONEY_NEGATIVE = "[ERROR] 구입금액은 음수를 입력할 수 없습니다.";
    public static final String ERROR_MONEY_MIN_PRICE = "[ERROR] Lotto 1장의 가격은 1000 입니다.";
    public static final String ERROR_INVALD_NUM = "[Error] 올바른 숫자가 아닙니다.";

    public static final String INPUT_PRICE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WIN_LOTTO = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS = "보너스 볼을 입력해 주세요.";
    public static final String OUTPUT_LOTTO_COUNT = "%d개를 구매했습니다.%n";
    public static final String OUTPUT_LOTTO_RESULT = "당첨 통계\n---------";
    public static final String OUTPUT_REWARD_RESULT = "3개 일치 (5000원)- %d개\n4개 일치 (50000원)- %d개\n5개 일치 (1500000원)- %d개\n5개 일치, 보너스 볼 일치(30000000원)- %d개\n6개 일치 (2000000000원)- %d개%n";
    public static final String OUTPUT_PROFIT_RESULT = "총 수익률은 %.2f입니다.";
    public static final String OUTPUT_PROFIT_UNDER = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
}
