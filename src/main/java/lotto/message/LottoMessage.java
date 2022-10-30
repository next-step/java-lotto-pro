package lotto.message;

public class LottoMessage {
    public static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    public static final String PURCHASE_RESULT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    public static final String INPUT_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String WINNING_STATISTIC = "당첨 통계";
    public static final String DIVIDER_LINE = "---------";
    public static final String WINNING_STATISTIC_RESULT = "%d개 일치%s(%s원)- %d개";
    public static final String BONUS_NUMBER_MATCHING = ", 보너스 볼 일치";
    public static final String EMPTY_SPACE = " ";
    public static final String PROFIT = "총 수익률은 %.2f입니다.";
    public static final String LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String INPUT_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_LOTTO_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";

    private LottoMessage() {
    }
}
