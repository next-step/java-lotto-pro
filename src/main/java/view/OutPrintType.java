package view;

enum OutPrintType {

    LOTTO_RESULT("당첨 통계"),
    SAME_COUNT("개 일치"),
    TOTAL_GET_PERCENT("총 수익률은 "),
    STANDARD_RESULT("입니다.(기준이 1이기 때문에 결과적으로 "),
    MEAN_RESULT("라는 의미임"),
    COUNT_INPUT("개"),
    WON_INPUT("원) - "),
    SAME_BONUS_BALL(", 보너스볼 일치"),
    WIN_RESULT("이득이"),
    LOSE_RESULT("손해"),
    MANUAL("수동으로"),
    AUTO("장, 자동으로"),
    BUY_COUNT("개를 구매 했습니다.")
    ;


    private final String message;

    OutPrintType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
