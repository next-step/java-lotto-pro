package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public class ResultView {

	private static final String NEXT_LINE = "\n";
	private static final String PROFIT_RATIO_PRINT_FORMAT = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 %s 라는 의미임)";

	public void printLottoTickets(LottoTickets lottoTickets) {
		StringBuilder ticketStringBuilder = new StringBuilder();
		appendLottoCount(lottoTickets, ticketStringBuilder);
		ticketStringBuilder.append(lottoTickets);
		System.out.println(ticketStringBuilder);
	}

	private void appendLottoCount(LottoTickets lottoTickets, StringBuilder ticketStringBuilder) {
		ticketStringBuilder.append(lottoTickets.count()).append("개를 구매했습니다.");
		ticketStringBuilder.append(NEXT_LINE);
	}

	public void printResult(RankResult rankResult, Money inputMoney) {
		StringBuilder resultBuilder = new StringBuilder();
		resultBuilder.append("당첨 통계").append(NEXT_LINE);
		resultBuilder.append("---------").append(NEXT_LINE);
		appendResultPerRank(rankResult, resultBuilder);
		appendProfitRatio(rankResult.profitRate(inputMoney), resultBuilder);
		System.out.println(resultBuilder);
	}

	private static void appendResultPerRank(RankResult rankResult, StringBuilder resultBuilder) {
		rankResult.getRankResult()
			.forEach((key, value) -> {
				if (key.equals(Rank.SECOND)) {
					resultBuilder.append(String.format("%d개 일치, 보너스 볼 일치 (%d원)- %d개%n",
						key.getMatchCount(),
						key.getPrize(),
						value));
					return;
				}
				resultBuilder.append(String.format("%d개 일치 (%d원) - %d개%n",
					key.getMatchCount(),
					key.getPrize(),
					value));
			});
	}

	public static void appendProfitRatio(double profitRate, StringBuilder resultBuilder) {
		resultBuilder.append(String.format(PROFIT_RATIO_PRINT_FORMAT, profitRate, profitRate > 1 ? "이득" : "손해"));
	}

	public void printErrorMessage(String message) {
		System.out.println(message);
	}
}
