package step3;

public enum LottoMessage {

    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    WIN_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n---------"),
    MATCH_THREE(Award.THREE.getCount() + "개 일치 (" + Award.THREE.getAmount() + "원)- "),
    MATCH_FOUR(Award.FOUR.getCount() + "개 일치 (" + Award.FOUR.getAmount() + "원)- "),
    MATCH_FIVE(Award.FIVE.getCount() + "개 일치 (" + Award.FIVE.getAmount() + "원)- "),
    MATCH_SIX(Award.SIX.getCount() + "개 일치 (" + Award.SIX.getAmount() + "원)- "),
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
