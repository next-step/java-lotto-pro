package step3.view;

import java.math.BigDecimal;

import step3.lotto.LottoPapers;
import step3.winner.WinningResultMap;

public interface ResultView {
	void purchasedLottoPrint(LottoPapers lottoPapers);

	void purchasedCount(int autoCount, int manualCount);
	void statisticsPrint(WinningResultMap statistics);
	void yieldPrint(BigDecimal statistics);
}
