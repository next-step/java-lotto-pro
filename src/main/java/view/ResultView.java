package view;

import static lotto.common.Constants.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Winning;
import lotto.common.Messages;
import lotto.common.Rank;

public class ResultView {
	public static void print(String message) {
		System.out.println(message);
	}

	public static void purchaseResult(Lottos lottos) {
		print(lottos.getLottoList().size() + Messages.BOUGHT_OF.getValues());
		for (Lotto lotto : lottos.getLottoList()) {
			print(lotto.getNumbers().toString());
		}
		print("");
	}

	public static void totalResult(Winning winning, int investment) {
		print(Messages.WINNING_STATS.getValues());
		print("--------");
		Rank[] ranks = Rank.valuesForResult();
		for (Rank rank : ranks) {
			print(createWinningResult(rank, winning.getStrikeResult(rank)));
		}
		print(Messages.RESULT_FORMAT.getValues().replace("{0}", winning.getYield(investment)));
	}

	private static String createWinningResult(Rank rank, Integer result) {
		StringBuilder sb = new StringBuilder();
		sb.append(rank.toString());
		sb.append(result);
		sb.append(Messages.QUANTITY.getValues());
		return sb.toString();
	}

}
