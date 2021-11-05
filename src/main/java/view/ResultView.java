package view;

import static java.util.stream.Collectors.*;

import java.math.BigDecimal;

import model.Lotto;
import model.LottoStatistics;
import model.Lottos;
import model.MatchResult;

public class ResultView {

	public static final String PURCHASE_MESSAGE = "%d개를 구매했습니다.";
	public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
	public static final String LINE = "---------";
	public static final String THREE_MATCH_MESSAGE = "3개 일치 (%d원)- %d개";
	public static final String FOUR_MATCH_MESSAGE = "4개 일치 (%d원)- %d개";
	public static final String FIVE_MATCH_MESSAGE = "5개 일치 (%d원)- %d개";
	public static final String SIX_MATCH_MESSAGE = "6개 일치 (%d원)- %d개";
	public static final String EARNINGS_RATE_MESSAGE = "총 수익률은 %f입니다.";
	public static final String EARNINGS_RATE_LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

	public void printPurchaseVolumeMessage(int purchaseVolume) {
		System.out.println(String.format(PURCHASE_MESSAGE, purchaseVolume));
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
			.collect(joining(", ", "[", "]"));
	}

	private void nextLine() {
		System.out.println();
	}
}
