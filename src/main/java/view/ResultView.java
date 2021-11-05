package view;

import common.Messages;
import investment.Investment;
import lotto.Lotto;
import lotto.LottoList;
import lotto.Rank;
import lotto.Winning;

public class ResultView {
	private ResultView() {
	}

	public static void print(String message) {
		System.out.println(message);
	}

	public static void purchaseResult(Integer manualCount, Integer autoCount, LottoList lottoList) {
		print(Messages.BOUGHT_OF_FORMAT.getValues(new Integer[] {manualCount, autoCount}));
		print(lottoList.toString());
		print("");
	}

	public static void totalResult(Winning winning, Investment investment) {
		print(Messages.WINNING_STATS.getValues());
		print("--------");
		Rank[] ranks = Rank.valuesForResult();
		for (Rank rank : ranks) {
			print(createWinningResult(rank, winning.getStrikeResult(rank)));
		}
		print(Messages.RESULT_FORMAT.getValues(new String[] {winning.getYield(investment)}));
	}

	private static String createWinningResult(Rank rank, Integer result) {
		StringBuilder sb = new StringBuilder();
		sb.append(rank.toString());
		sb.append(result);
		sb.append(Messages.QUANTITY.getValues());
		return sb.toString();
	}

}
