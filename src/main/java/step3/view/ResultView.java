package step3.view;

import step3.LottoPapers;

public interface ResultView {
	public void purchasedLottoPrint(LottoPapers lottoPapers);
	public void purchasedCount(int size);
	public void statisticsPrintAndYield(int yield);
}
