package step3;

public enum LottoMessage {

    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    WIN_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n---------"),
    MATCH_THREE("3개 일치 (5000원)- "),
    MATCH_FOUR("4개 일치 (50000원)- "),
    MATCH_FIVE("5개 일치 (1500000원)- "),
    MATCH_SIX("6개 일치 (2000000000원)- "),
    STATISTICS_RESULT("총 수익률은 ");

    private String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String resultStatistic(double value) {
        return STATISTICS_RESULT.message + value + "입니다.";
    }

    public String resultMatchNumber(int value) {
        return this.message + value + "개";
    }
}
