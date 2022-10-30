package step3.enums;

public enum Message {

    START("구입금액을 입력해 주세요."),
    COUNT("개를 구매했습니다."),
    WIN_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    STATISTICS("당첨 통계\n---------"),
    MATCH_THREE(Rank.FIFTH.getCount() + "개 일치 (" + Rank.FIFTH.getAmount() + "원)- "),
    MATCH_FOUR(Rank.FOURTH.getCount() + "개 일치 (" + Rank.FOURTH.getAmount() + "원)- "),
    MATCH_FIVE(Rank.THIRD.getCount() + "개 일치 (" + Rank.THIRD.getAmount() + "원)- "),
    MATCH_FIVE_BONUS(Rank.THIRD.getCount() + "개 일치, 보너스 볼 일치(" + Rank.SECOND.getAmount() + "원)- "),
    MATCH_SIX(Rank.FIRST.getCount() + "개 일치 (" + Rank.FIRST.getAmount() + "원)- "),
    STATISTICS_RESULT("총 수익률은 "),
    BONUS("보너스 볼을 입력해 주세요."),
    MENUAL("수동으로 구매할 번호를 입력해 주세요.");

    private String message;

    Message(String message) {
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

    public String resultMatchNumber(int manual, int auto) {
        return "수동으로" + manual + "장, 자동으로 " + auto + "개를 구매했습니다.";
    }

}
