package study.step3.message;

public enum LottoMessage {

    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    OUTPUT_COUNTS_OF_LOTTOS_FORMAT("%d개를 구매했습니다.\n"),
    OUTPUT_COUNTS_OF_ALL_RANKS_FORMAT("%d개 일치%s(%d원) - %d개\n"),
    OUTPUT_RATE_OF_RETURN_FORMAT("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)"),
    ERROR_BONUS_NUMBER_IS_INCLUDING_WINNING_NUMBERS("당첨 번호에 보너스볼 번호가 포함되어 있습니다."),
    OUTPUT_LOTTO_RANK_IS_NOT_MATCHED_BONUS_NUMBER(""),
    OUTPUT_LOTTO_RANK_IS_MATCHED_BONUS_NUMBER(", 보너스 볼 일치");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
