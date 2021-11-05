package common;

public enum Messages {
	INPUT_AMOUNT("구입금액을 입력해 주세요."),
	INPUT_MANUAL_AMOUNT("수동으로 구매할 로또 수를 입력해 주세요."),
	INPUT_MANUAL_NUMBER("수동으로 구매할 번호를 입력해 주세요."),
	BOUGHT_OF("수동으로 {0}장, 자동으로 {1}개를 구매했습니다."),
	INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
	INPUT_BONUS_BALL("보너스 볼을 입력해 주세요."),
	WINNING_STATS("당첨 통계"),
	MATCHED("개 일치"),
	WON("원"),
	QUANTITY("개"),
	BONUS_BALL_MATCHED("보너스 볼 일치"),
	RESULT_FORMAT("총 수익률은 {0}입니다.");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
