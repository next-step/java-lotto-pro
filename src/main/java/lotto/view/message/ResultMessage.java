package lotto.view.message;

import lotto.view.message.dto.MatchResultParameters;

public enum ResultMessage {

    BUY_LOTTO("수동으로 %d장, 자동으로 %d장을 구매했습니다.")
    , WINNER_STATISTICS("당첨 통계")
    , WINNER_MATCH_RESULT("%d개 일치 (%s원) - %d개")
    , WINNER_MATCH_BONUS_RESULT("%d개 일치, 보너스 볼 일치 (%s원) - %d개")
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

    public String of(MatchResultParameters dto) {
        return String.format(this.message, dto.matchCount(), dto.prize(), dto.statisticCount());
    }

    public String ofRateResult(double rate) {
        return String.format(this.message, rate);
    }
}
