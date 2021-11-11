package step3.view;

import java.math.BigDecimal;

import step3.lotto.LottoPapers;
import step3.winner.Winning;

public interface ResultView {
	void purchasedLottoPrint(LottoPapers lottoPapers);
	void purchasedCount(int size);
	void statisticsPrint(Winning statistics);
	void yieldPrint(BigDecimal statistics);
}
