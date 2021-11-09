package step3.view;

import java.math.BigDecimal;

import step3.lotto.LottoPapers;
import step3.winner.Winner;

public class ReturnView implements ResultView {

	private static final String MESSAGE_BUY_COUNT = "%s개를 구매했습니다.";
	private static final String MESSAGE_WINNING_STATISTICS = "당첨 통계";
	private static final String MESSAGE_PERFORATED_LINE = "---------";
	private static final String MESSAGE_TOTAL_YIELD = "총 수익률은 %d 입니다.";

	public void purchasedLottoPrint(LottoPapers lottoPapers) {
		System.out.println(lottoPapers);
	}

	public void purchasedCount(int size) {
		System.out.println(String.format(MESSAGE_BUY_COUNT, size));
	}

	public void statisticsPrint(Winner winner) {
		System.out.println(MESSAGE_WINNING_STATISTICS);
		System.out.println(MESSAGE_PERFORATED_LINE);
		System.out.println(winner);
	}

	public void yieldPrint(BigDecimal yield) {
		System.out.println(String.format(MESSAGE_TOTAL_YIELD, yield));	}
}
