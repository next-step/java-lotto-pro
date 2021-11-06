package lotto.ui;

public enum Message {

    PURCHASE_AMOUNT_INPUT("구입 금액을 입력해 주세요."),
    WIN_NUMBER_INPUT("지난 주 당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT("보너스 볼을 입력해 주세요."),
    NOT_DIGIT_ERROR("숫자만 입력해주세요."),

    LOTTOS_PRINT("%d개를 구매했습니다.%n"),
    WIN_RESULTS_PRINT("%d개 일치 (%d원) - %d개%n"),
    PROCEEDS_PRINT("총 수익률은 %.2f입니다.%s%n"),
    PROCEEDS_COMMENT("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
    WIN_RESULT_HEADER("당첨 통계"),
    BAR_PRINT("---------");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
