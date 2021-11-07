package step3.view;

import step3.LottoPapers;
import step3.winner.Winner;

public interface ResultView {
	public void purchasedLottoPrint(LottoPapers lottoPapers);
	public void purchasedCount(int size);
	public void statisticsPrintAndYield(Winner winner);
}
