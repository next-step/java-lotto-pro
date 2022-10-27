package lotto.ui;

public enum ConsoleMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_COMPLETE("%d개를 구매했습니다."),
    OUTPUT_WINNING_RESULT_TITLE("당첨 통계\n---------"),
    OUTPUT_WINNING_RESULT("%d개 일치 (%d원)- %d개"),
    OUTPUT_YIELDS("총 수익률은 %.2f 입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
