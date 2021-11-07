package view;

import static java.util.stream.Collectors.*;
import static view.ResultMessage.*;

import model.EarningsRate;
import model.Lotto;
import model.Lottos;
import model.MatchResult;
import model.MatchingNumberCount;
import model.Money;
import model.PurchaseCount;

public class ResultView {

	public static final String COMMA_AND_SPACE_DELIMITER = ", ";
	public static final String OPEN_SQUARE_BRACKET = "[";
	public static final String CLOSE_SQUARE_BRACKET = "]";

	public static void printPurchaseVolumeMessage(PurchaseCount purchaseCount) {
		System.out.println(String.format(PURCHASE_MESSAGE, purchaseCount));
	}

	public static void printWinningStatisticsMessage(MatchResult matchResult, Money purchaseMoney) {
		nextLine();
		System.out.println(WINNING_STATISTICS_MESSAGE);
		System.out.println(LINE);
		printMatchResult(matchResult);
		printEarningsRate(matchResult, purchaseMoney);
	}

	private static void printEarningsRate(MatchResult matchResult, Money purchaseMoney) {
		EarningsRate earningsRate = EarningsRate.calculateOf(matchResult, purchaseMoney);
		System.out.print(String.format(EARNINGS_RATE_MESSAGE, earningsRate));
		if (earningsRate.isLessThanOne()) {
			System.out.println(EARNINGS_RATE_LOSS_MESSAGE);
		}
	}

	private static void printMatchResult(MatchResult matchResult) {
		System.out.println(
			String.format(THREE_MATCH_MESSAGE, MatchingNumberCount.THREE.getPrizeMoney(),
				matchResult.getThreeMatchCount()));
		System.out.println(
			String.format(FOUR_MATCH_MESSAGE, MatchingNumberCount.FOUR.getPrizeMoney(),
				matchResult.getFourMatchCount()));
		System.out.println(
			String.format(FIVE_MATCH_MESSAGE, MatchingNumberCount.FIVE.getPrizeMoney(),
				matchResult.getFiveMatchCount()));
		System.out.println(
			String.format(FIVE_AND_BONUS_MATCH_MESSAGE, MatchingNumberCount.FIVE_AND_BONUS.getPrizeMoney(),
				matchResult.getFiveAndBonusBallMatchCount()));
		System.out.println(
			String.format(SIX_MATCH_MESSAGE, MatchingNumberCount.SIX.getPrizeMoney(),
				matchResult.getSixMatchCount()));
	}

	public static void printLottoNumbers(Lottos lottos) {
		lottos.getValues()
			.stream()
			.map(ResultView::lottoNumberToStringForPrint)
			.forEach(System.out::println);
	}

	private static String lottoNumberToStringForPrint(Lotto lotto) {
		return lotto.getNumbers()
			.stream()
			.map(String::valueOf)
			.collect(joining(COMMA_AND_SPACE_DELIMITER, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
	}

	private static void nextLine() {
		System.out.println();
	}
}
