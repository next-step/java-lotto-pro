package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Result;

public class ResultView {

	private static final String NEXT_LINE = "\n";

	public void printLottoTickets(LottoTickets lottoTickets) {
		StringBuilder ticketStringBuilder = new StringBuilder();
		appendLottoCount(lottoTickets, ticketStringBuilder);
		ticketStringBuilder.append(lottoTickets);
		System.out.println(ticketStringBuilder);
	}

	private void appendLottoCount(LottoTickets lottoTickets, StringBuilder ticketStringBuilder) {
		ticketStringBuilder.append(lottoTickets.size()).append("개를 구매했습니다.");
		ticketStringBuilder.append(NEXT_LINE);
	}

	public void printResult(Result result) {
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append("당첨 통계").append(NEXT_LINE);
		resultBuilder.append("---------").append(NEXT_LINE);
		resultBuilder.append(result);
		System.out.println(resultBuilder);
	}

	public void printProfitRate(double profitRate) {
		StringBuilder profitRateBuilder = new StringBuilder();
		profitRateBuilder.append("총 수익률은 ").append(profitRate).append("입니다.");
		profitRateBuilder.append(" (기준이 1이기 때문에 결과적으로 ").append(profitRate > 1 ? "이득" : "손해").append("라는 의미임)");
		System.out.println(profitRateBuilder);
	}
}
