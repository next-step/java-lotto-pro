package view;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PRINT_NUMBER_OF_PURCHASED_LOTTO("%s개를 구매했습니다."),
    ASK_WINNER_TICKET("지난 주 당첨 번호를 입력해 주세요."),
    PRINT_STATISTICS_INTRO("당첨 통계\n---------"),
    PRINT_TOTAL_EARNING_RATE("총 수익률은 %s 입니다."),
    PRINT_NEW_LINE("");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
