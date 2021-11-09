package step3.view;

import java.math.BigDecimal;

import step3.LottoPapers;
import step3.winner.Winner;

public interface ResultView {
	void purchasedLottoPrint(LottoPapers lottoPapers);
	void purchasedCount(int size);
	void statisticsPrint(Winner statistics);
	void yieldPrint(BigDecimal statistics);
}
