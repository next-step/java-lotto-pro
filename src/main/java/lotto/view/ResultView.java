package lotto.view;

import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.RankResult;

public class ResultView {

	private static final String NEXT_LINE = "\n";
	private static final String PROFIT_RATIO_PRINT_FORMAT = "총 수익률은 %.2f 입니다. (기준이 1이기 때문에 결과적으로 %s 라는 의미임)";
	private static final String INPUT_MANUAL_LOTTO_TICKET_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
	private static final String TICKET_COUNT_MESSAGE_FORMAT = "수동으로 %d개, 자동으로 %d개 구매하였습니다.\n";

	public void printLottoTickets(LottoTickets lottoTickets) {
		System.out.println(lottoTickets);
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

	public void printManualLottiTicketsMessage() {
		System.out.println(INPUT_MANUAL_LOTTO_TICKET_NUMBERS_MESSAGE);
	}

	public void printLottoTicketsCount(int manualCount, int randomCount) {
		System.out.printf(TICKET_COUNT_MESSAGE_FORMAT, manualCount, randomCount);

	}
}
