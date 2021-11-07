package step3.view;

import step3.LottoPapers;
import step3.Winner;

public class ReturnView implements ResultView {

	public void purchasedLottoPrint(LottoPapers lottoPapers) {
		System.out.println(lottoPapers);
	}

	public void purchasedCount(int size) {
		System.out.println(String.format("%s개를 구매했습니다.", size));
	}

	public void statisticsPrintAndYield(Winner winner) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		System.out.println(winner);
	}
}
