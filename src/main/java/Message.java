public enum Message {

	INPUT_PAY_KRW("구입금액을 입력해 주세요."),
	INPUT_MANUAL_LOTTO_QUANTITY("수동으로 구매할 로또 수를 입력해 주세요."),
	INPUT_MANUAL_LOTTOS("수동으로 구매할 번호를 입력해 주세요."),
	INPUT_WINNING_LOTTO("지난 주 당첨 번호를 입력해 주세요."),
	INPUT_WINNING_BONUS("보너스 볼을 입력해 주세요."),
	BOUGHT_LOTTO("수동으로 %d장, 자동으로 %d개를 구매했습니다."),
	WINNING_STATISTICS("당첨 통계"),
	SEPARATOR("---------"),
	MATCH_WINNING_BONUS(", 보너스 볼 일치"),
	COUNT_MATCHING("%d개 일치%s(%d%s)- %d개"),
	EARNING_RATE("총 수익률은 %.2f입니다."),
	EARNING_RATE_NOTE("(기준이 1이기 때문에 결과적으로 손해라는 의미임)"),
	ERROR("[ERROR] %s");

	private final String content;

	Message(String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}
