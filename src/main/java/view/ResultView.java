package view;

import model.LottoPurchasePrice;
import model.Rank;
import model.RewardCalculator;

public class ResultView {
	public static void showResult(LottoPurchasePrice lottoPurchasePrice, RewardCalculator rewardCalculator) {
		System.out.println(getMessage(lottoPurchasePrice, rewardCalculator));
	}

	private static String getMessage(LottoPurchasePrice lottoPurchasePrice, RewardCalculator rewardCalculator) {
		float revenueRate = rewardCalculator.sumReward() / (float)lottoPurchasePrice.get();
		return new StringBuilder()
			.append("당첨 통계\n")
			.append("---------\n")
			.append(String.format("3개 일치 (%d원)- %d개\n", Rank.FIFTH.getReward(), rewardCalculator.getCount(Rank.FIFTH)))
			.append(String.format("4개 일치 (%d원)- %d개\n", Rank.FOURTH.getReward(), rewardCalculator.getCount(Rank.FOURTH)))
			.append(String.format("5개 일치 (%d원)- %d개\n", Rank.THIRD.getReward(), rewardCalculator.getCount(Rank.THIRD)))
			.append(String.format("5개 일치, 보너스 볼 일치 (%d원)- %d개\n", Rank.SECOND.getReward(), rewardCalculator.getCount(Rank.SECOND)))
			.append(String.format("6개 일치 (%d원)- %d개\n", Rank.FIRST.getReward(), rewardCalculator.getCount(Rank.FIRST)))
			.append(String.format("총 수익률은 %.2f입니다.\n", revenueRate))
			.toString();
	}
}
