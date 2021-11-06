package lotto.domain;

public enum Message {

    LOTTO_NUMBER_BOUND_ERROR("로또 숫자는 %d~%d 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 숫자는 중복될 수 없습니다."),
    LOTTO_NUMBER_SIZE_ERROR("로또 숫자는 %d개 여야 합니다."),
    PURCHASE_AMOUNT_MIN_ERROR("로또 구매 금액은 %d원 이상이어야 합니다."),

    LOTTOS_PRINT("%d개를 구매했습니다."),
    WIN_RESULTS_PRINT("%d개 일치 (%d원) - %d개"),
    PROCEEDS_PRINT("총 수익률은 %.2f입니다.%s"),
    PROCEEDS_COMMENT("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageForTest() {
        return message.replace("%d", "\\d+");
    }
}
