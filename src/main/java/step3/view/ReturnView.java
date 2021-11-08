package step3.view;

import static step3.Constant.*;
import static step3.winner.WinningAmount.*;

import step3.Constant;
import step3.LottoPapers;
import step3.winner.WinningAmount;

public class ReturnView implements ResultView {

	public void purchasedLottoPrint(LottoPapers lottoPapers) {
		System.out.println(lottoPapers);
	}

	public void purchasedCount(int size) {
		System.out.println(String.format("%s개를 구매했습니다.", size));
	}

	public void statisticsPrintAndYield(int yield) {
		System.out.println("당첨 통계");
		System.out.println("---------");
		StringBuilder sb = new StringBuilder();
		sb.append(THREE.getMessage()).append(WinningAmount.THREE.getMatch()).append(EACH).append(Constant.ENTER);
		sb.append(FOUR.getMessage()).append(WinningAmount.FOUR.getMatch()).append(EACH).append(ENTER);
		sb.append(FIVE.getMessage()).append(WinningAmount.FIVE.getMatch()).append(EACH).append(ENTER);
		sb.append(SIX.getMessage()).append(WinningAmount.SIX.getMatch()).append(EACH).append(ENTER);
		sb.append(TOTAL_YIELD).append(yield).append(END_OF_WORD);
		System.out.println(sb);
	}
}
