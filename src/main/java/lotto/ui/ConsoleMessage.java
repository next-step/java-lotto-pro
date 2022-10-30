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
    OUTPUT_YIELDS("총 수익률은 %.2f 입니다."),
    ERROR_VALID_LOTTO_PRICE("%d원으로 %d개 로또를 구매할 수 없습니다."),
    ERROR_VALID_NUMBER_FORMAT("'%s'는 숫자가 아닙니다."),
    ERROR_VALID_BONUS_NUMBER("보너스 번호가 당첨 번호와 중복 되었습니다."),
    ERROR_VALID_LOTTO_NUMBER("%d는 1~45 범위에 벗어난 숫자입니다."),
    ERROR_VALID_LOTTO_NUMBERS("로또를 생성하기 위해서는 중복되지 않은 숫자 6개가 필요 합니다.");

    private final String message;

    ConsoleMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
