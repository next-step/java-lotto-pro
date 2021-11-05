package view;

import static java.util.stream.Collectors.*;
import static view.ResultMessage.*;

import java.math.BigDecimal;

import model.Lotto;
import model.LottoStatistics;
import model.Lottos;
import model.MatchResult;
import model.PurchaseCount;

public class ResultView {

	public static final String COMMA_AND_SPACE_DELIMITER = ", ";
	public static final String OPEN_SQUARE_BRACKET = "[";
	public static final String CLOSE_SQUARE_BRACKET = "]";

	public void printPurchaseVolumeMessage(PurchaseCount purchaseVolume) {
		System.out.println(String.format(PURCHASE_MESSAGE, purchaseVolume.toString()));
	}

	public void printWinningStatisticsMessage(MatchResult matchResult, int purchaseAmount) {
		nextLine();
		System.out.println(WINNING_STATISTICS_MESSAGE);
		System.out.println(LINE);
		printMatchResult(matchResult);
		printEarningsRate(matchResult, purchaseAmount);
	}

	private void printEarningsRate(MatchResult matchResult, int purchaseAmount) {
		BigDecimal earningsRate = LottoStatistics.calculateForEarningsRate(matchResult, purchaseAmount);
		System.out.print(String.format(EARNINGS_RATE_MESSAGE, earningsRate));
		if (isEarningsRateLessThanOne(earningsRate)) {
			System.out.println(EARNINGS_RATE_LOSS_MESSAGE);
		}
	}

	private boolean isEarningsRateLessThanOne(BigDecimal earningsRate) {
		return BigDecimal.ONE.compareTo(earningsRate) > 0;
	}

	private void printMatchResult(MatchResult matchResult) {
		System.out.println(
			String.format(THREE_MATCH_MESSAGE, LottoStatistics.THREE_MATCH_PAYOUT.intValue(), matchResult.getThreeMatchCount()));
		System.out.println(
			String.format(FOUR_MATCH_MESSAGE, LottoStatistics.FOUR_MATCH_PAYOUT.intValue(), matchResult.getFourMatchCount()));
		System.out.println(
			String.format(FIVE_MATCH_MESSAGE, LottoStatistics.FIVE_MATCH_PAYOUT.intValue(), matchResult.getFiveMatchCount()));
		System.out.println(
			String.format(SIX_MATCH_MESSAGE, LottoStatistics.SIX_MATCH_PAYOUT.intValue(), matchResult.getSixMatchCount()));
	}

	public void printLottoNumbers(Lottos lottos) {
		lottos.getValues()
			.stream()
			.map(this::lottoNumberToStringForPrint)
			.forEach(System.out::println);
	}

	private String lottoNumberToStringForPrint(Lotto lotto) {
		return lotto.getNumbers()
			.stream()
			.map(String::valueOf)
			.collect(joining(COMMA_AND_SPACE_DELIMITER, OPEN_SQUARE_BRACKET, CLOSE_SQUARE_BRACKET));
	}

	private void nextLine() {
		System.out.println();
	}
}
