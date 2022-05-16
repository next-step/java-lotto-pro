package lotto;

public class Message {

    public static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.%n";
    public static final String INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.%n";
    public static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.%n";

    public static final String PURCHASE_LOTTO_COUNT_MESSAGE = "%d개를 구매했습니다.%n";
    public static final String PRINT_LOTTO_NUMBERS = "[ %s ]%n";
    public static final String STATISTICS_START_MESSAGE = "%n당첨 통계%n---------%n";
    public static final String TOTAL_SUMMARY_MESSAGE = "%d개 일치 (%s원)- %d개%n";
    public static final String RETURN_RATE_MESSAGE = "총 수익률은 %f 입니다.";
    public static final String LOSS_STATISTICS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)%n";

    private Message() {
    }
}
