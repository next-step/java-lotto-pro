package step3.view2;

import java.math.BigDecimal;

public class ViewConstant {
    public static final String ONLY_NUMBER = "숫자만 입력 해주세요.";
    public static final String BONUS_RANK_NAME = "SECOND";
    public static final String TITLE = "당첨 통계\n";
    public static final String DIVIDE = "---------\n";
    public static final String LOTTO_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    public static final String YIELD_MESSAGE_FORMAT = "총 수익률은 %s입니다";
    public static final String LOTTO_RANK_FORMAT = "%s개 일치 (%d원)- %d개";
    public static final String LOTTO_RANK_BONUS_SECOND_FORMAT = "%s개 일치, 보너스 볼 일치(%s원) - %s개";
    public static final String WINNER_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String AMOUNT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String BONUS_NUMBER_REQUEST_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String BUY_COUNT_MESSAGE = "%d 개를 구매했습니다.";
    public static final String TOTAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 %s장, 자동으로 %s개를 구매했습니다.";
    public static final BigDecimal LOSS = BigDecimal.valueOf(1);
    public static final Integer MIN_RANK_NUMBER = 3;
    public static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String MANUAL_LOTTO_NUMBER_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String COMMA_INPUT_REQUEST_MESSAGE = "콤마로 분리된 숫자만 입력해주세요(1,2,3,4,5,6)";
}
