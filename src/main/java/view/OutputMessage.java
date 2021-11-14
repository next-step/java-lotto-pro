package view;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNER_TICKET("지난 주 당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    STATISTICS_INTRO("당첨 통계\n---------"),
    NUMBER_OF_PURCHASED_LOTTO_FORMAT("%s개를 구매했습니다."),
    LOTTO_TICKET_FORMAT("[%s]"),
    LOTTO_RESULTS_FORMAT("%s- %d개"),
    LOTTO_RESULT_FORMAT("%d개 일치 (%d원)"),
    TOTAL_EARNING_RATE_FORMAT("총 수익률은 %s입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
