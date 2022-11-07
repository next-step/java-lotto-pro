package lotto.view;

public enum Messages {

    ASK_PAYMENT("구입 금액을 입력해 주세요."),
    ASK_MANUAL_lOTTO_CNT("수동으로 구매할 로또 수를 입력해 주세요."),
    ASK_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요."),
    NOTIFY_PURCHASES("수동으로 %d장, 자동으로 %d장을 구매했습니다."),
    ASK_LAST_WIN_LOTTO_NUMBERS("지난 주 당첨 번호를 입력해주세요."),
    ASK_BONUS_NUMBERS("보너스 볼을 입력해 주세요."),
    WIN_STATISTICS("당첨 통계"),
    MESSAGE_DELIMITER("--------------"),
    SHOW_WINNING_INFO("%d개 일치 (%d원) - %d개"),
    SHOW_SECOND_WINNING_INFO("%d개 일치, 보너스 볼 일치 (%d원) - %d개"),
    SHOW_TOTAL_YIELD("총 수익률은 %.2f입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임)");

    private String msg;

    Messages(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return this.msg;
    }

}
