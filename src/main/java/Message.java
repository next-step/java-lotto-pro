public enum Message {

	INPUT_PAY_KRW("구입금액을 입력해 주세요."),
	INPUT_WINNING_LOTTO("지난 주 당첨 번호를 입력해 주세요."),
	BOUGHT_LOTTO("%d개를 구매했습니다."),
	WINNING_STATISTICS("당첨 통계"),
	SEPARATOR("---------"),
	COUNT_MATCHING("%d개 일치 (%d%s)- %d개"),
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
