package lotto.view;

import java.util.Arrays;

import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningRecord;

public class ResultView {

	public static final int STANDARD_RATE = 1;
	public static final String PRINT_PURCHASE_QUANTITY = "%d개를 구매했습니다.%n";
	public static final String PRINT_RETURN_RATE = "총 수익률은 %.2f 입니다.";
	public static final String PRINT_MONEY_LOSS = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
	public static final String PRINT_LOTTO_RECORD = "%d개 일치 (%s원)- %d개%n";
	public static final String WINNING_STAT_INFO = "당첨 통계";
	public static final String DASH = "---------";

	public static void printLottoPurchaseQuantity(int purchaseQuantity) {
		System.out.printf(PRINT_PURCHASE_QUANTITY, purchaseQuantity);
	}

	public static void printLottos(Lottos lottos) {
		System.out.println(lottos.toString());
	}

	public static void printWinningRecord(WinningRecord winningRecord) {
		Arrays.stream(Rank.values())
			.filter(rank -> Rank.FAILED != rank)
			.sorted((o1, o2) -> Long.valueOf(o1.getMatchCount()-o2.getMatchCount()).intValue())
			.forEach(rank ->
				System.out.printf(
					PRINT_LOTTO_RECORD,
					rank.getMatchCount(), rank.getPrizeMoney(), winningRecord.getPlaceCount(rank)
				)
			);
	}

	public static void printReturnRate(double rate) {
		System.out.printf(PRINT_RETURN_RATE, rate);
		if (STANDARD_RATE > rate) {
			System.out.println(PRINT_MONEY_LOSS);
		}
	}

	public static void printWinningStat(WinningRecord winningRecord, double rate){
		System.out.println(WINNING_STAT_INFO);
		System.out.println(DASH);
		printWinningRecord(winningRecord);
		printReturnRate(rate);
	}
}
