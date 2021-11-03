package view;

import static lotto.common.Constants.*;

import java.util.Map;

import lotto.Lotto;
import lotto.Lottos;
import lotto.Winning;
import lotto.common.Messages;

public class ResultView {
	public static void print(String message) {
		System.out.println(message);
	}

	public static void purchaseResult(Lottos lottos) {
		print(lottos.getLottoList().size() + Messages.BOUGHT_OF.getValues());
		for (Lotto lotto: lottos.getLottoList()) {
			print(lotto.getNumbers().toString());
		}
		print("");
	}

	public static void totalResult(Winning winning, int investment) {
		print(Messages.WINNING_STATS.getValues());
		print("--------");
		for (Map.Entry<Integer, Integer> entry : WINNING_AMOUNT_MAP.entrySet()) {
			print(createWinningResult(entry, winning.getStrikeResult(entry.getKey())));
		}
		print(Messages.RESULT_FORMAT.getValues().replace("{0}", winning.getYield(investment)));
	}

	private static String createWinningResult(Map.Entry<Integer, Integer> winningAmount, Integer result) {
		StringBuilder sb = new StringBuilder();
		sb.append(winningAmount.getKey());
		sb.append(Messages.MATCHED.getValues());
		sb.append(" (");
		sb.append(winningAmount.getValue());
		sb.append(Messages.WON.getValues());
		sb.append(") - ");
		sb.append(result);
		sb.append(Messages.QUANTITY.getValues());
		return sb.toString();
	}

}
