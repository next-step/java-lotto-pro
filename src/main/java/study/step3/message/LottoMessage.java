package study.step3.message;

public enum LottoMessage {

    INPUT_WINNING_NUMBERS("지난 주 당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 볼을 입력해 주세요."),
    OUTPUT_COUNTS_OF_LOTTOS_FORMAT("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n"),
    OUTPUT_COUNTS_OF_ALL_RANKS_FORMAT("%d개 일치%s(%d원) - %d개\n"),
    OUTPUT_RATE_OF_RETURN_FORMAT("총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)"),
    ERROR_LOTTO_NUMBER_SHOULD_BE_NUMBER("로또 번호는 숫자만 입력할 수 있습니다."),
    ERROR_LOTTO_NUMBER_SHOULD_BE_NOT_EMPTY("로또 번호가 입력되지 않았습니다."),
    ERROR_LOTTO_NUMBER_IS_GREATER_THAN_MINIMUM("로또 번호는 1이상이어야 합니다."),
    ERROR_LOTTO_NUMBER_IS_LESS_THAN_MAXIMUM("로또 번호는 45이하이어야 합니다."),
    ERROR_WINNING_NUMBERS_SHOULD_BE_NUMBER("로또 번호는 숫자만 입력할 수 있습니다."),
    ERROR_BONUS_NUMBER_IS_INCLUDING_WINNING_NUMBERS("당첨 번호에 보너스볼 번호가 포함되어 있습니다."),
    OUTPUT_LOTTO_RANK_IS_NOT_MATCHED_BONUS_NUMBER(""),
    OUTPUT_LOTTO_RANK_IS_MATCHED_BONUS_NUMBER(", 보너스 볼 일치"),
    ERROR_WINNING_NUMBERS_SHOULD_BE_NOT_EMPTY("지난주 당첨 번호가 입력되지 않았습니다."),
    ERROR_BONUS_NUMBER_SHOULD_BE_NOT_EMPTY("보너스볼이 입력되지 않았습니다."),
    INPUT_MANUAL_LOTTO_NUMBERS("수동으로 구매할 번호를 입력해 주세요.");

    private final String message;

    LottoMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
