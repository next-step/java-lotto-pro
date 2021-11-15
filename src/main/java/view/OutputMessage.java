package view;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_MANUAL_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    ASK_MANUAL_TICKET("수동으로 구매할 번호를 입력해 주세요."),
    ASK_WINNER_TICKET("지난 주 당첨 번호를 입력해 주세요."),
    ASK_BONUS_BALL("보너스 볼을 입력해 주세요."),
    STATISTICS_INTRO("당첨 통계\n---------"),
    NUMBER_OF_PURCHASED_LOTTO_FORMAT("수동으로 %d장, 자동으로 %d장을 구매했습니다."),
    TICKET_FORMAT("[%s]"),
    RANKS_FORMAT("%s- %d개"),
    RANK_FORMAT("%d개 일치 (%d원)"),
    BONUS_RANK_FORMAT("%d개 일치, 보너스 볼 일치(%d원)"),
    TOTAL_EARNING_RATE_FORMAT("총 수익률은 %s입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
