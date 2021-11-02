package lotto.common;

public enum Messages {

	INPUT_AMOUNT("구입금액을 입력해 주세요."),
	BOUGHT_OF("개를 구매했습니다."),
	INPUT_WINNING_NUMBER("지난 주 당첨 번호를 입력해 주세요."),
	WINNING_STATS("당첨 통계"),
	MATCHED("개 일치"),
	WON("원"),
	QUANTITY("개"),
	RESULT_FORMAT("총 수익률은 {0}입니다.");

	private String values;

	Messages(String values) {
		this.values = values;
	}

	public String getValues() {
		return values;
	}
}
