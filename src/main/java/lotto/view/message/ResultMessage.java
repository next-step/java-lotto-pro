package lotto.view.message;

public enum ResultMessage {

    BUY_LOTTO("%d개를 구매했습니다.")
    , WINNER_STATISTICS("당첨 통계")
    , WINNER_MATCH_RESULT("%d개 일치 (%s원) - %d개")
    , TOTAL_RATE_RESULT("총 수익률은 %.2f 입니다.")
    , LINE("---------")
    ;

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
