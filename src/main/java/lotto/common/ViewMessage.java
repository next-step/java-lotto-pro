package lotto.common;

public enum ViewMessage {
    MATCH_RESULT_MESSAGE("%d개 일치 (%d원) - %d개"),
    MATCH_RESULT_WITH_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    BUY_MESSAGE("%d개를 구매했습니다.%n"),
    LOSS_MESSAGE("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.2f입니다."),
    STATISTICS_MESSAGE_HEADER("당첨 통계\n---------"),
    INPUT_MONEY_MESSAGE("구입금액을 입력해주세요."),
    INPUT_WIN_LOTTO_MESSAGE("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 볼을 입력해 주세요."),
    INPUT_MANUAL_LOTTO_COUNT_MESSAGE("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_MANUAL_LOTTO_NUMBER_MESSAGE("수동으로 구매할 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
