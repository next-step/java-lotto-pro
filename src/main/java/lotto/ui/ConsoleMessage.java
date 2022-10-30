package lotto.ui;

public enum ConsoleMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    INPUT_PURCHASE_MANUAL_LOTTO_COUNT("수동으로 구매할 로또 수를 입력해 주세요."),
    INPUT_PURCHASE_MANUAL_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_COMPLETE("수동으로 %d개, 자동으로 %d개를 구매했습니다."),
    OUTPUT_WINNING_RESULT_TITLE("당첨 통계\n---------"),
    OUTPUT_WINNING_RESULT("%d개 일치 (%d원)- %d개"),
    OUTPUT_WINNING_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%d원)- %d개"),
    OUTPUT_YIELDS("총 수익률은 %.2f 입니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
