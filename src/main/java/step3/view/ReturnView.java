package step3.view;

import java.math.BigDecimal;

import step3.lotto.LottoPapers;
import step3.winner.Rank;
import step3.winner.WinningResultMap;

public class ReturnView implements ResultView {

	private static final String MESSAGE_BUY_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
	private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
	private static final String MESSAGE_PERFORATED_LINE = "---------";
	private static final String MESSAGE_TOTAL_YIELD = "총 수익률은 %s 입니다.";

	public void purchasedLottoPrint(LottoPapers lottoPapers) {
		System.out.println(lottoPapers);
	}

	public void purchasedCount(int autoCount,int manualCount) {
		System.out.println(String.format(MESSAGE_BUY_COUNT, autoCount, manualCount));
	}

	public void statisticsPrint(WinningResultMap winning) {
		System.out.println(MESSAGE_WINNING_STATISTICS);
		System.out.println(MESSAGE_PERFORATED_LINE);
		StringBuilder sb = new StringBuilder();

		for (Rank rank : Rank.reverse()) {
			sb.append(String.format("%d개 일치 (%d)- %d개\n", rank.getMatch(), rank.getAmount(), winning.get(rank)));
		}
		System.out.println(sb);
	}

	public void yieldPrint(BigDecimal yield) {
		System.out.println(String.format(MESSAGE_TOTAL_YIELD, yield.toString()));	}
}
